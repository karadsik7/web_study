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
	<div class="main">
		<div class="content">
			<table>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>월급</th>
					<th>입사일</th>
				</tr>
				<c:forEach var="evo" items="${requestScope.empList }">
				<tr>
					<td>${evo.employee_id }</td>
					<td>${evo.first_name }</td>
					<td>${evo.salary }</td>
					<td>${evo.hire_date }</td>
				</tr>	
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>