<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ch18_guestbook/css/style.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	function del(password, id){
		var user_password = prompt("비밀번호를 입력해주세요.");
		if(password != user_password){
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}else{
			//서버로 삭제 요청
			location.href = "${pageContext.request.contextPath}/book/delete?id=" + id;
		}
	}
	
	function mod(password, id){
		var user_password = prompt("비밀번호를 입력하세요.");
		if(password != user_password){
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}else{
			location.href = "${pageContext.request.contextPath}/book/modify?id=" + id;
		}
	}
</script>
</head>
<body>
	<div class="main">
		<div class="header">
			<h1 class="title">GUEST BOOK</h1>
		</div>
		<hr />
		<div class="footer">
			<button class="big" type="button" onclick="location.href='/ch18_guestbook/book/add'">Write</button>
		</div>
		<hr />
		<div class="content">
		<c:if test="${empty bookList }">
			<p class="text_center">첫 게시물을 작성해 보세요~!</p>
		</c:if>
		<c:forEach var="bvo" items="${bookList }">
			<div class="comment">
				<div class="msg">${bvo.msg }</div>
				<div class="grid_3_7">
					<div class="text_center">Writer</div>
					<div>${bvo.writer }(${bvo.ip })</div>
				</div>
				<div class="grid_3_7">
					<div class="text_center">Date</div>
					<div>${bvo.writedate }</div>
				</div>
				<div class="text_center">
					<button type="button" class="smaLL" onclick="del('${bvo.password }', '${bvo.id }');">Delete</button>
					<button type="button" class="smaLL" onclick="mod('${bvo.password }', '${bvo.id }');">Modify</button>
				</div>
			</div>
		</c:forEach>
		</div>
	</div>
</body>
</html>