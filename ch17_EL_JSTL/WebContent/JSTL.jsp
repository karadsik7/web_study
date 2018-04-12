<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL 임포트 -->
<!-- 코어 (주요 자바 문법 있음) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!-- 포맷 -->
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String[] cityArray = {"서울", "대전", "대구", "부산"};
	pageContext.setAttribute("cityArray", cityArray);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{
		border: 1px solid pink;
	}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	<!-- 스크립트릿 방식으로 구구단 작성했을 때 -->
	<table>
		<%for(int i = 2; i <= 9; i++){ %>
		<tr>
			<%for(int j = 1; j <= 9; j++){ %>
			<td><%=i %> x <%=j %> = <%=i*j %></td>
			<%} %>
		</tr>
		<%} %>
	</table>
	
	<!-- EL과 JSTL방식 -->
	<!-- forEach문 -->
	<table>
		<c:forEach begin="2" end="9" var="i">
			<tr>
				<c:forEach begin="1" end="9" var="j">
				<td>${i } x ${j } = ${i*j }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<hr />
	<ul>
	<%for(String city : cityArray){%>
		<li><%=city %></li>
	<%} %>
	</ul>
	<ul>
		<c:forEach items="${pageScope.cityArray }" var="city">
			<li>${city }</li>
		</c:forEach>
	</ul>
	<hr />
	<!-- if문 : 주의 - else없으므로 if문을 여러번써야함 -->
	<c:if test="${param.user == null }">
		<p>로그인하세요</p>
	</c:if>
	<c:if test="${param.user != null}">
		<p>${param.user }님 안녕하세요?</p>
	</c:if>
	
	<hr />
	
	<!-- 포맷활용 통화(돈) 출력방식 --> <!-- 3단위마다 , 구분하는 숫자 -->
	<f:formatNumber type="currency" currencySymbol="#" value="12345678" />
	<br />
	<!-- 3단위로 숫자 출력 -->
	<f:formatNumber type="number" value="12345678" />
	
	
	
</body>
</html>