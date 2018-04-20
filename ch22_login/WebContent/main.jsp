<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	<div class="main">
		<div class="header">
			<!-- 특정한 중복 태그들을 외부의 1개 파일로 처리 -->
			<!-- 1. jsp:include 사용 -->
			<jsp:include page="menu.jsp" />
			<h1 class="title text_center">Main Page</h1>
		</div>
		<div class="content">
			
		</div>
	</div>
</body>
</html>