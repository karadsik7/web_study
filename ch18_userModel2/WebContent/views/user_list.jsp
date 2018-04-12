<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Model2 방식은 기능의 분리
	서블릿: Data access object(dao)에 명령을 수행하도록 지시하고 jsp(view)에 데이터를 넘겨주는 중개자 역할
	Dao : 모델 객체이고 Vo(value object)를 이용해서 데이터를 포장하고 실질적으로 db에 접속해서 db 관련 명령 처리
	jsp : 브라우저에 view 역할만 수행한다.-->
<!-- 따라서 jsp에는 처리 역할을 수행하는, 다시 말해 모든 자바 코드가 있어서는 안됨(백엔드 개발자의 역할) -->
<!-- Model2 방식으로 변환하기 위해 jsp에서 처리역할을 하던 자바코드를 삭제하고 
	이를 서블릿으로 이관하는 것이 model2 리팩토링의 방법 -->
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.table, th, td{
		border : 1px solid black;
		padding : 10px;
	}
	.table{
		border-collapse: collapse;
		width: 100%;
	}
	.content{
		width : 400px;
		margin : 0 auto;
	}
	.footer{
		width : 400px;
		margin : 50px auto;
	}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	function del(id){
		var check = window.confirm("정말로 삭제하시겠습니까?");
		if(check){
			location.href = "/ch18_userModel2/user/del?id="+id;	
		}
	}
	
	function mod(id){
		location.href = "/ch18_userModel2/user/modify?id="+id;
	}
	
	
</script>
</head>
<body>
	<div class="main">
		<div class="content">
			<table>
				<caption>:::회원 리스트:::</caption>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>비고</th>
				</tr>
				<!-- 포문돌리던 자바코드 대신 jstl과 EL을 사용해서 받아온 userList객체만을 이용해서 출력 -->
				<c:forEach var="u" items="${requestScope.userList }">
				<tr>
					<td>${u.id }</td>
					<td>${u.name }</td>
					<td>
						<button type="button" onclick="mod('${u.id}')">수정</button>
						<button type="button" onclick="del('${u.id}');">삭제</button>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="footer">
			<form action="/ch18_userModel2/user/add" method="post">
			<table>
				<caption>:::회원 추가:::</caption>
				<tr>
					<th>아이디</th> 
					<td><input type="text" name="id" placeholder="추가 아이디 입력"/></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" placeholder="회원 실명 입력"/></td>
				</tr>
				<tr>
					<td colspan = "2">
						<button type="submit">전송</button>
						<button type="reset">취소</button>
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
</body>
</html>