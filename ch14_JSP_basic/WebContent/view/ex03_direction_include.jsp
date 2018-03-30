<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- include 지시어(<%@)는 파싱할때 하나의 문서로 합쳐지기 때문에 변수를 공유할 수 있다 --%>
<% String name = "홍길동"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
    <!-- include 지시어의 절대경로는 모듈패스를 반드시 생략해야 적용된다. -->
	<%@ include file="/view/menu.jsp" %>
	<p>메인페이지</p>
</body>
</html>