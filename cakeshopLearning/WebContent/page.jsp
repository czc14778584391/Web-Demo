<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<div><div style='text-align:center;'>
<a class='btn btn-info'<c:if test="${p.pagenum}==2">disabled</c:if> <c:if test="${p.pagenum!=1 }">href="${pageContext.request.contextPath }${param.URL}?pagenum=1${param.param}"</c:if> >首页</a>
<a class='btn btn-info'<c:if test="${p.pagenum}==2">disabled</c:if>  <c:if test="${p.pagenum!=1 }">href="${pageContext.request.contextPath }${param.URL}?pagenum=${p.pagenum-1}${param.param}"</c:if>>上一页</a>
<h3 style='display:inline;'>[${p.pagenum}/${p.totalpage}]</h3>
<h3 style='display:inline;'>[${p.totalCount}]</h3>
<a class='btn btn-info'<c:if test="${p.pagenum==p.totalpage||p.totalpage==0}">disabled</c:if> <c:if test="${p.pagenum!=p.totalpage}">href="${pageContext.request.contextPath }${param.URL}?pagenum=${p.pagenum+1}${param.param}"</c:if>>下一页</a>
<a class='btn btn-info' <c:if test="${p.pagenum==p.totalpage||p.totalpage==0}">disabled</c:if> <c:if test="${p.pagenum!=p.totalpage}">href="${pageContext.request.contextPath }${param.URL}?pagenum=${p.totalpage}${param.param}"</c:if> >尾页</a>
<input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' href='javascript:void(0);' onclick='location.href="${pageContext.request.contextPath }${param.URL}?${param.param}&pagenum="+(this.previousSibling.value)'>GO</a>
</div>
</div>
