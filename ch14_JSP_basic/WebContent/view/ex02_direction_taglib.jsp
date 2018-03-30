<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	<ul>
		<%for(int i = 0; i < 10; i++){ %>
			<li><%=i+1 %>번째 행</li>
		<%} %>
	</ul>
	<hr />
	<ul>
		<core:forEach var="i" begin="1" end="10">
			<li>${i}번째 행</li>
		</core:forEach>
	</ul>
</body>
</html>