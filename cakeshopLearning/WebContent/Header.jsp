<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
	<!--header-->
	<div class="header">
		<div class="container">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<h1 class="navbar-brand"><a href="${pageContext.request.contextPath}">蛋糕店</a></h1>
				</div>
				<!--navbar-header-->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="${pageContext.request.contextPath}"  <c:if test="${param.flag==1}">class="active"</c:if>>首页</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle <c:if test="${param.flag==2}">active</c:if>" data-toggle="dropdown">商品分类<b class="caret"></b></a>
							<ul class="dropdown-menu multi-column columns-2">
								<li>
									<div class="row">
										<div class="col-sm-12">
											<h4>商品分类</h4>
											<ul class="multi-column-dropdown">
												
													<li><a class="list" href="${pageContext.request.contextPath}/goods_List">全部商品</a></li>
												<c:forEach  items="${typeList}" var="t">
													<li><a class="list" href="${pageContext.request.contextPath}/goods_List?id=${t.id}">${t.name}</a></li>
												</c:forEach>
 
											</ul>
										</div>	
									</div>
								</li>
							</ul>
						</li>
						<li><a href="${pageContext.request.contextPath}/goodsList_Recommend?typeid=2" <c:if test="${param.flag==3&&type==2}">class="active"</c:if> >热销</a></li>
						<li><a href="${pageContext.request.contextPath}/goodsList_Recommend?typeid=3" <c:if test="${param.flag==3&&type==3}">class="active"</c:if>>新品</a></li>
						
						<c:choose>
						<c:when test="${!empty userSession}">
						<li><a href="${pageContext.request.contextPath}/mycenter.jsp" <c:if test="${param.flag==4}">class="active"</c:if> >个人中心</a></li>
						<li><a href="${pageContext.request.contextPath}/order_list" <c:if test="${param.flag==7}">class="active"</c:if> >个人订单</a></li>
						<li><a href="${pageContext.request.contextPath}/user_loginout">退出</a></li>
						</c:when>
						<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/register.jsp" >注册</a></li>
						<li><a href="${pageContext.request.contextPath}/login.jsp" >登录</a></li>
						</c:otherwise>
						</c:choose>
							
						<c:if test="${!empty userSession&&userSession.isadmin}">
						<li><a href="${pageContext.request.contextPath}/admin/login.jsp" >后台管理</a></li>
						</c:if>
						
					</ul> 
					<!--/.navbar-collapse-->
				</div>
				<!--//navbar-header-->
			</nav>
			<div class="header-info">
				<div class="header-right search-box">
					<a href="javascript:;"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>				
					<div class="search">
						<form class="navbar-form" action="${pageContext.request.contextPath }/search_goods">
							<input type="text" class="form-control" name="Keywold"/>
							<button type="submit" class="btn btn-default" aria-label="Left Align">搜索</button>
						</form>
					</div>	
				</div>
				
				<div class="header-right cart">
					<a href="${pageContext.request.contextPath }/cart.jsp">
						<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"><span class="card_num">${order.amount}</span></span>
					</a>
				</div>
				<div class="header-right login">
					<span class="glyphicon" aria-hidden="true"></span><c:if test="${!empty userSession}">${userSession.name}</c:if>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!--//header-->