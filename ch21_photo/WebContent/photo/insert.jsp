<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style.css" />
<style>
	table{
	    border-collapse: collapse;
	    text-align: left;
	    line-height: 1.5;
	    border-top: 1px solid #ccc;
	    border-left: 3px solid #369;
	 	margin : 20px 0;
	 	background : #eeeeee;
	}
	th {
	    width: 147px;
	    padding: 10px;
	    font-weight: bold;
	    vertical-align: top;
	    color: #153d73;
	    border-right: 1px solid #ccc;
	    border-bottom: 1px solid #ccc;
	
	}
	td {
	    width: 349px;
	    padding: 10px;
	    vertical-align: top;
	    border-right: 1px solid #ccc;
	    border-bottom: 1px solid #ccc;
	}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	<!-- 입력폼, from태그, table태그, input*3(title, password, photo), submit버튼 -->
	
	<div class="main">
		<div class="content">
			<form action="insert" method="post" enctype="multipart/form-data">
				<table>
					<caption>:::사진 추가:::</caption>
					<tr>
						<th>Title</th>
						<td><input type="text" name="title" /></td>
					</tr>
					<tr>
						<th>Password</th>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<th>Photo Upload</th>
						<td><input type="file" name="photo"/></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;">
						<button>전송</button>
						<button type="button" onclick="history.back();">취소</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	
	
	<!-- PhotoInsertServlet(/photo/insert), MultipartRequest -->
	
	<!-- PhotoDao insert메서드로 DB작업 -->
	
	<!-- 리다이렉트 -->
</body>
</html>