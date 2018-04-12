<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
			location.href = "/ch18_scoreModel2/score/delete?id="+id;	
		}
	}
	
	function modify(id){
		location.href = "/ch18_scoreModel2/score/modify?id="+id;
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
				<!-- items에 requestScope.scoreList인데 생략했을 때 우선순위로 따지면 컨텍스트에 scoreList를
				선언하지 않았으므로 자동적으로 리퀘스트를 찾기 때문에 생략해도 무방함 -->
				<c:forEach var="svo" items="${scoreList }">
				<tr>
					<!-- EL방식은 게터의 이름만 적어도 자동으로 게터를 호출함  -->
					<td>${svo.id }</td>
					<td>${svo.name }</td>
					<td>${svo.kor }</td>
					<td>${svo.eng }</td>
					<td>${svo.math }</td>
					<td>${svo.total }</td>
					<td>${svo.avg }</td>
					<td>
						<button type="button" 
						onclick="modify(${svo.id});">수정</button>
						<button type="button" 
						onclick="del(${svo.id});">삭제</button>
					</td>
				</tr>
				</c:forEach>
				
			</table>
		</div>
		<div class="footer">
			<form action="/ch18_scoreModel2/score/add" method="post">
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