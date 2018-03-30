<%@page import="com.inc.vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	PersonVo pvo = new PersonVo();
	pvo.setName("jjs");
	pvo.setAge(27);
	pvo.setGender("male");
	%> --%>
	<!-- 유즈빈에서 아이디에 변수명을 클래스엔 게터세터가 있는 클래스를 지정하고
	셋프로퍼티로 세터역할을 한다 (프로퍼티엔 세터의 변수명 네임엔 유즈빈에 지정한 변수명 밸류엔 지정할 값) -->
<jsp:useBean id="pvo" class="com.inc.vo.PersonVo" />
<jsp:setProperty property="name" name="pvo" value="jjs" />
<jsp:setProperty property="age" name="pvo" value="27" />
<jsp:setProperty property="gender" name="pvo" value="male" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	<%-- <p>이름 : <%= pvo.getName() %></p>
	<p><%=pvo.getAge() %></p>
	<p><%=pvo.getGender() %></p> --%>
	
	<!-- 가져올 땐 프로퍼티엔 게터의 변수명 네임엔 유즈빈의 변수명을 지정하면 됨 -->
	<p>이름: <jsp:getProperty property="name" name="pvo"/>  </p>
	<p>나이: <jsp:getProperty property="age" name="pvo"/></p>
	<p>나이: <jsp:getProperty property="gender" name="pvo"/></p>
	
</body>
</html>