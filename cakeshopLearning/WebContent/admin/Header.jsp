<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/admin/admin_index.jsp">蛋糕店后台</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li ><a href="${pageContext.request.contextPath}/admin/order_List">订单管理</a></li>
					<li ><a href="${pageContext.request.contextPath}/admin/user_List">客户管理</a></li>
					<li ><a href="${pageContext.request.contextPath}/admin/goods_list">商品管理</a></li>
					<li ><a href="${pageContext.request.contextPath}/admin/goodstype_list">类目管理</a></li>
					<li ><a href="${pageContext.request.contextPath}/admin/admin_reset.jsp">修改管理员密码</a></li>
					<li><a href="${pageContext.request.contextPath}/user_loginout">退出</a></li>
				</ul>
			</div>
		</div>