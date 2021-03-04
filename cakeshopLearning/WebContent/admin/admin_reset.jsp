 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>修改密码</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">


	<jsp:include page="/admin/Header.jsp"></jsp:include>
	<br><br>
	<c:if test="${!empty msg}">
	<div class="alert alert-success" role="alert">${msg}</div>
	</c:if>
	<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/admin_Reset" method="post">
		<input type="hidden" name="admin.id" value="1">
		<input type="hidden" name="admin.username" value="1">
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">用户名</label>
			<div class="col-sm-5">${userSession.username}</div>
		</div>
		<div class="form-group">
			<label for="input_pass" class="col-sm-1 control-label">原密码</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="input_pass" name="password" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="input_pass_new" class="col-sm-1 control-label">新密码</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="input_pass" name="passwordNew" required="required">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" class="btn btn-success">提交修改</button>
			</div>
		</div>
	</form>
	
	<span style="color:red;"></span>
	
</div>	
</body>
</html>