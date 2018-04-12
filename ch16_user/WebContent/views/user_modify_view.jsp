<%@page import="com.inc.vo.UserVo"%>
<%@page import="com.inc.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 우선 필요한 것은 해당 회원의 아이디를 받아와서 그 아이디를 토대로 select * from users 해서 보여줘야함-->
<!-- 그렇다면 dao를 통해 우선 그 회원 하나의 정보만 받아오는 메서드를 통해서 vo를 받고 출력 -->
<%
	UserDao userDao = UserDao.getInstance();
	String id = request.getParameter("id");
	UserVo uvo = userDao.oneView(id);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<style>
table, th, td{
		border : 1px solid black;
	}
	table{
		width: 100%;
		border-collapse: collapse;
	}
	.content{
		width : 300px;
		margin: 0 auto;
	}
	th, td{
		padding : 10px;
		text-align: center;
	}
	caption{
		padding: 10px;
	}
</style>
</head>
<body>
	<div class="main">
		<div class="content">
		<!-- 히든태그를 통해서, 최종적으로 sql문에서 필요한 id값은 보관하고 있어야한다. 따라서 이것도
		넘겨준다.-->
				<!-- form태그를 통해 넘겨준다 -->
			<form action="user_modify.jsp" method="post">
			<input type="hidden" name="id" value="<%=uvo.getId() %>" />
			<table>
				<caption>:::회원 이름 수정:::</caption>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="<%=uvo.getName()%>"/></td>
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