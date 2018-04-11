<%@page import="com.inc.vo.UserVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.inc.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 1. dao를 불러오고 받아올 데이터의 배열을 선언하고 Dao의 메서드를 통해 db 데이터를 가져온다 -->
<% 
	UserDao userDao = UserDao.getInstance();
	ArrayList<UserVo> userList = userDao.selectList();	
%>

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
	//삭제 함수
	function del(id){
		var check = window.confirm("정말로 삭제하시겠습니까?");
		if(check){
			location.href = "user_del.jsp?id="+id;	
		}
	}
	
	function mod(id){
		//수정은 따로 수정페이지가 존재하도록 만들 것이므로 수정페이지로 보내준다.
		location.href = "user_modify_view.jsp?id="+id;
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
				<!-- 2. 포문으로 회원 정보 DB와 연동하기 -->
				<%for(UserVo i : userList){%>
				<tr>
					<td><%=i.getId() %></td>
					<td><%=i.getName() %></td>
					<td>
						<button type="button" onclick="mod('<%=i.getId() %>')">수정</button>
						<!-- 자바스크립트로 파라미터 넘길때 문자열 값이면 반드시 따옴표 넣어줘야함 안그러면
						자바스크립트가 파라미터값의 이름으로된 var변수나 함수를 찾다가 undefined 예외 발생 -->
						<button type="button" onclick="del('<%=i.getId() %>');">삭제</button>
					</td>
				</tr>
				<%} %>
				<!-- 여기까지 -->
			</table>
		</div>
		<div class="footer">
			<!-- 여기는 사용자가 직접 입력해 DB에 데이터를 추가하는 과정이므로 form태그를 작성해서
			서블릿쪽으로 날려줘야한다. -->
			<!-- 해당 서블릿 or jsp가 있는 경로를 action에 지정하고 method에는 get이나 post방식 중 택일 -->
			<form action="user_add.jsp" method="post">
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
			<!-- 여기까지 -->
		</div>
	</div>
</body>
</html>