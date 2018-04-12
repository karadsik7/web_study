<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
			<form action="/ch18_userModel2/user/modify" method="post">
			<input type="hidden" name="id" value="${uvo.id }" />
			<table>
				<caption>:::회원 이름 수정:::</caption>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${uvo.name }"/></td>
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