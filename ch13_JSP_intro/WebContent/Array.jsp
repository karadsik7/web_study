<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] cityArray = {"서울", "대전", "대구", "부산"};
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	<select name="" id="">
		<option value="">:::선택:::</option>
		<%for(String i : cityArray){ %>
			<option value=""><%=i %></option>
		<%} %>
	</select>
</body>
</html>