<%@page import="com.inc.vo.ScoreVo"%>
<%@page import="com.inc.dao.ScoreDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	ScoreVo svo = ScoreDao.getInstance().selectOne(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	<div class="main">
		<div class="content">
			<form action="score_update.jsp" method="post">
			<input type="hidden" name = "id" value=<%=svo.getId() %>>
			<table>
				<caption>:::성적 수정:::</caption>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="<%=svo.getName() %>"/></td>
				</tr>
				<tr>
					<th>국어</th>
					<td><input type="text" name="kor" value="<%=svo.getKor() %>"/></td>
				</tr>
				<tr>
					<th>영어</th>
					<td><input type="text" name="eng" value="<%=svo.getEng() %>"/></td>
				</tr>
				<tr>
					<th>수학</th>
					<td><input type="text" name="math" value="<%=svo.getMath() %>" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">전송</button>
						<button type="reset" onclick="history.back();">취소</button>
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
	
</body>
</html>