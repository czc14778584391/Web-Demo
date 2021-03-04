  <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<title>客户列表</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<jsp:include page="/admin/Header.jsp"></jsp:include>
	
	<div class="text-right"><a class="btn btn-warning" href="${pageContext.request.contextPath}/admin/user_add.jsp">添加客户</a></div>
		
	<br>
	
	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="10%">用户名</th>
		<th width="10%">电话</th>
		<th width="10%">地址</th>
		<th width="10%">操作</th>
	</tr>
	<c:forEach items="${p.list}" var="u">
	
         <tr>
         	<td><p>${u.id}</p></td>
         	<td><p>${u.username}</p></td>
         	<td><p>${u.phone}</p></td>
         	<td><p>${u.address}</p></td>
			<td>
				<a class="btn btn-info" href="${pageContext.request.contextPath}/admin/user_reset?id=${u.id}">重置密码</a>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/user_Edit?id=${u.id}">修改</a>
				<a class="btn btn-danger" href="${pageContext.request.contextPath}/admin/user_Delete?id=${u.id}">删除</a>
			</td>
       	</tr>
     
     </c:forEach>
</table>

<br>
<jsp:include page="/page.jsp">
<jsp:param value="/admin/user_List" name="URL"/>
</jsp:include>
<br>
</div>
</body>
</html>