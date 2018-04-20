<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="menu">
	<c:if test="${sessionScope.id == null }">
		<li onclick = "location.href = '${pageContext.request.contextPath}/member/signin'">Login</li>
		<li onclick = "location.href = '${pageContext.request.contextPath}/member/signup'">Sign up</li>
	</c:if>
	<c:if test="${sessionScope.id != null }">
		<li onclick = "location.href = '${pageContext.request.contextPath}/member/signout'">Logout</li>
	</c:if>
		<li onclick = "location.href = '${pageContext.request.contextPath}/gallery'">Gallery</li>
	
</ul>