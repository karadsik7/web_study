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
					<th>도시명</th>
					<th>거리명</th>
					<th>부서목록</th>
				</tr>
				<c:forEach var="lvo" items="${locList }">
				<tr>
					<td>${lvo.city }</td>
					<td>${lvo.street_address }</td>
					<td>
						<table>
							<tr>
								<th>부서번호</th>
								<th>부서명</th>
							</tr>
							<c:forEach var="dvo" items="${lvo.deptList }">
							<tr>
								<td>${dvo.department_id }</td>
								<td>${dvo.department_name }</td>
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