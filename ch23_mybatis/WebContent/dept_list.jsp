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
					<th>부서명</th>
					<th>사원 목록</th>
				</tr>
				<c:forEach var="dvo" items="${requestScope.deptList }">
				<tr>
					<td>${dvo.department_id }</td>
					<td>${dvo.department_name }</td>
					<td>
						<table>
							<tr>
								<th>사원 번호</th>
								<th>사원 이름</th>
							</tr>
							<c:forEach var="evo" items="${dvo.empList }">
							<tr>
								<td>${evo.employee_id }</td>
								<td>${evo.first_name }</td>
							</tr>
							</c:forEach>
						</table>
					</td>
				</tr>	
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>