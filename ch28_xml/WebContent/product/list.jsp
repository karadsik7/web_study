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
	<form action="${pageContext.request.contextPath}/product/list" method="get">
		<input type="text" name="searchText"/>
		<button type="submit">검색</button>
	</form>
	<hr />
	<table>
		<caption>:::상품리스트:::</caption>
		<tr>
			<th>이미지</th>
			<th>제품명</th>
			<th>최저가</th>
			<th>최고가</th>
			<th>판매몰</th>
		</tr>
		<c:forEach var="product" items="${productList }">
		<tr>
			<td><img src="${product.image }" alt="" style="width:100px; height: 100px;"/></td>
			<td><a href="${product.link }">${product.title }</a></td>
			<td>${product.lowPrice }</td>
			<td>${product.highPrice }</td>
			<td>${product.mallName }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>