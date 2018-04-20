<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	<table>
		<caption>:::cookie:::</caption>
		<tr>
			<th>아이디</th>
			<td><input type="text" value="${requestScope.id }" /></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" value="${requestScope.name }" /></td>
		</tr>
	</table>
</body>
</html>