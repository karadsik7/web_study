<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
<div class="container">
	<div class="header">
		<h3 class="title text_center">자유게시판</h3>
	</div>
	<div class="body">
		<table class="board">
			<tr>
				<th style="width:10%">번호</th>
				<th style="width:55%">제목</th>
				<th style="width:15%">이름</th>
				<th style="width:10%">날짜</th>
				<th style="width:10%">조회</th>
			</tr>
			<c:if test="${empty boardList }">
			<tr>
				<td colspan="5">게시물이 존재하지 않습니다.</td>
			</tr>
			</c:if>
			<c:forEach var="bvo" items="${boardList }">
			<tr>
				<td>${bvo.id }</td>
				<td><a href="${pageContext.request.contextPath}/board/view?id=${bvo.id}">${bvo.title }</a></td>
				<td>${bvo.name }</td>
				<td>
					<f:parseDate var="date" value="${bvo.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/>
					<f:formatDate value="${date }" pattern="yyyy/MM/dd" />
				</td>
				<td>${bvo.hit }</td>
			</tr>
			</c:forEach>
		</table>
		<div class="buttons">
			<button type="button" onclick="location.href='${pageContext.request.contextPath}/board/add'">글쓰기</button>
		</div>
	</div>
	<div class="footer">
	
	</div>
</div>
</body>
</html>