<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(function(){
		var resultJSON = JSON.parse('${resultJSON }');
		//JSON.items (하위 엘리먼트의 배열)
		for(var item of resultJSON.items){
			//헝가리 표기법 : 첫글자에 자료형을 암시하는 명명법 i(정수), $(jquery) 등
			var $tr = $("<tr class='item'>");
			var $td = $("<td>");
			var $img = $("<img>").attr("src", item.image);
			$img.css("width", "100px");
			$td.append($img);
			$tr.append($td);
			$tr.append($("<td>").html(item.title));
			$tr.append($("<td>").text(item.lprice));
			$tr.append($("<td>").text(item.hprice));
			$tr.append($("<td>").text(item.mallName));
			$("#view").append($tr);
		}
	});
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/product/listJSON" method="get">
		<input type="text" name="searchText"/>
		<button type="submit">검색</button>
	</form>
	<hr />
	<table id="view">
		<caption>:::상품리스트:::</caption>
		<tr>
			<th>이미지</th>
			<th>제품명</th>
			<th>최저가</th>
			<th>최고가</th>
			<th>판매몰</th>
		</tr>
		
	</table>
</body>
</html>