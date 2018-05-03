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
		<tr>
			<th>이름</th>
			<th>나이</th>
			<th>번호종류</th>
			<th>전화번호</th>
		</tr>
		<c:forEach var="person" items="${personList }">
			<tr>
				<td>${person.getChildText("name") }</td>
				<td>${person.getChildText("age") }</td>
				<td>${person.getChild("phone").getAttributeValue }</td>
				<td>${person.getChildText("phone") }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>