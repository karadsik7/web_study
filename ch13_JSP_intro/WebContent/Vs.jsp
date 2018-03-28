<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String msg = request.getParameter("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	<%for(int i = 0; i < 5; i++){
		%>
		<h1>여기는 JSP</h1>
	<% }%> 
		
	<p><%=msg %></p>
	<table>
		<tr>
			<td>Servlet</td>
			<td>VS</td>
			<td>JSP</td>
		</tr>
	</table>
</body>
</html>