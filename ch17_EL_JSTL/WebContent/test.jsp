<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	<ul>
		<!-- 영역명을 생략했을 때 우선순위 : 1)페이지 2)리퀘스트 3)세션 4)어플-->
		<li>${msg }</li>
		<!-- 파라미터영역 -->
		<li>${param.msg }</li>
		<!-- 페이지스코프 -->
		<li>${pageScope.msg }</li>
		<!-- 리퀘스트스코프 -->
		<li>${requestScope.msg }</li>
		<!-- 세션스코프 -->
		<li>${sessionScope.msg }</li>
		<!-- 어플리케이션스코프 -->
		<li>${applicationScope.msg }</li>
	</ul>
</body>
</html>