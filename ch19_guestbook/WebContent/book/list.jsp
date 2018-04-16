<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	function del(id){
		//ajax방식으로 소스에 비밀번호 숨기고 체크하기
		var xhr = new XMLHttpRequest();
		var method = "POST";
		var url = "${pageContext.request.contextPath}/book/password";
		var param = "id="+id;
		
		xhr.open(method, url, true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var password = xhr.responseText;
				var user_password = prompt("비밀번호를 입력해주세요.");
				if(password != user_password){
					alert("비밀번호가 일치하지 않습니다.");
					return;
				}else{
					location.href = "${pageContext.request.contextPath}/book/delete?id=" + id;
				}
			}
		}
		//POST방식일때는 send의 파라미터에 param이라는 파라미터를 넣어줘야함
		xhr.send(param);
	}
	
	function mod(id){
		//ajax 준비작업 
		//1. xhr 생성 
		//2. method, url, param 지정 
		//3. open의 파라미터에 (method, url, (비동기로 할것인가?) true 값)
		//3-1. 포스트방식일 경우에는 http헤더가 있어야 인코딩을 할 수 있기 때문에 관련 코드를 넣는다
		//4. 이벤트 감지자 생성
		//5. send() 실행 (POST방식일 경우엔 send의 파라미터로 param을 넣어주고 GET방식일때는url에 +param해준다)
		
		var xhr = new XMLHttpRequest();
		var method = "POST";
		var param = "id="+id;
		var url = "${pageContext.request.contextPath}/book/password";
		
		xhr.open(method, url, true)
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var password = xhr.responseText;
				var user_password = prompt("비밀번호를 입력하세요.");
				if(password != user_password){
					alert("비밀번호가 일치하지 않습니다.");
					return;
				}else{
					location.href = "${pageContext.request.contextPath}/book/modify?id=" + id;
				} 
			}
		}
		xhr.send(param);
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
			<button class="big" type="button" onclick="location.href='${pageContext.request.contextPath}/book/add'">Write</button>
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
					<button type="button" class="smaLL" onclick="del('${bvo.id }');">Delete</button>
					<button type="button" class="smaLL" onclick="mod('${bvo.id }');">Modify</button>
				</div>
			</div>
		</c:forEach>
		</div>
	</div>
</body>
</html>