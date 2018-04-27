<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
<div class="container">
	<div class="header">
		<h1 class="title text_center">자유게시판</h1>
	</div>
	<div class="body">
		<table class="board-view">
			<tr>
				<th width="30%">제목</th>
				<td>${board.title }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${board.name }</td>
			</tr>
			<tr>
				<th></th>
				<td colspan="2" class="content">${board.content }</td>
			</tr>
		</table>
		<div class="buttons">
			<button type="button" style="text-align: right" 
			onclick="location.href='${pageContext.request.contextPath}/board/list'">목록</button>
		</div>
	</div>
	
	<div class="footer">
	
	</div>
</div>
</body>
</html>