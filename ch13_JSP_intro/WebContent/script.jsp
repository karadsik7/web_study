<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	//이곳은 선언문 영역이며 서블릿으로 파싱될 때 서블릿의 필드 영역이다
	String sayHello = "안녕하세요?";

	private int sum(int a, int b){
		return a + b;
	}
	
	Random random = new Random();
%>
<%
	//이곳은 스크립트릿 영역이며 서블릿의 service() 메서드의 지역변수와 코드를 지정할 수 있다.
	String msg = request.getParameter("msg");
	response.getWriter().println("메세지: " + msg);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	스크립트 요소
	<!-- 표현식 : response.getWriter().print([표현식 내부])의 기능 -->
	<%=msg %>
	<%=sum(10, 20) %>
</body>
</html>