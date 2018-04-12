<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- EL은 ${영역명.변수명}의 형태로 작성  -->
<%
	//지역이 종료될때까지 유지
	String msg = "지역변수";
	//해당 페이지를 벗어나기 전까지 유지
	pageContext.setAttribute("msg", "PageScope 소속변수");
	//요청이 끝나기 전까지 유지
	request.setAttribute("msg", "requestScope 소속변수");
	//브라우저가 닫히기 전 또는 한계시간이 다다를때까지 유지
	session.setAttribute("msg", "SessionScope 소속변수");
	//톰캣과같은 서버가 꺼질때까지 유지
	application.setAttribute("msg", "Application 소속변수");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	<ul>
		<li><%=msg %></li>
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
	<a href="test.jsp">페이지 이동</a>
	
	
</body>
</html>