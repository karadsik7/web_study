<%@page import="com.inc.dao.ScoreDao"%>
<%@page import="com.inc.vo.ScoreVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ScoreDao scoreDao = ScoreDao.getInstance();
	ArrayList<ScoreVo> scoreList = scoreDao.selectList();
	
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
		width : 700px;
		margin: 0 auto;
	}
	th, td{
		padding : 10px;
		text-align: center;
	}
	caption{
		padding: 10px;
	}
	.footer{
		width : 300px;
		margin : 20px auto;
	}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	function del(id){
		var check = window.confirm("정말로 삭제하시겠습니까?");
		if(check){
			location.href = "score_del.jsp?id="+id;	
		}
	}
	
	function modify(id){
		location.href = "score_update_view.jsp?id="+id;
	}
</script>
</head>
<body>
	<div class="main">
		<div class="content">
			<table>
				<caption>:::성적 리스트:::</caption>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>국어</th>
					<th>영어</th>
					<th>수학</th>
					<th>합계</th>
					<th>평균</th>
					<th>비고</th>
				</tr>
				<%for(ScoreVo svo : scoreList){ %>
				<tr>
					<td><%=svo.getId() %></td>
					<td><%=svo.getName() %></td>
					<td><%=svo.getKor() %></td>
					<td><%=svo.getEng() %></td>
					<td><%=svo.getMath() %></td>
					<td><%=svo.getTotal() %></td>
					<td><%=svo.getAvg() %></td>
					<td>
						<button type="button" 
						onclick="modify(<%=svo.getId() %>);">수정</button>
						<button type="button" 
						onclick="del(<%=svo.getId() %>);">삭제</button>
					</td>
				</tr>
				<%} %>
			</table>
		</div>
		<div class="footer">
			<form action="score_add.jsp" method="post">
			<table>
				<caption>:::성적 추가:::</caption>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="name" placeholder="2~5글자 입력"/>
					</td>
				</tr>
				<tr>
					<th>국어</th>
					<td>
						<input type="text" name="kor" placeholder="0~100사이의 숫자"/>
					</td>
				</tr>
				<tr>
					<th>영어</th>
					<td>
						<input type="text" name="eng" placeholder="0~100사이의 숫자"/>
					</td>
				</tr>
				<tr>
					<th>수학</th>
					<td>
						<input type="text" name="math" placeholder="0~100사이의 숫자"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
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