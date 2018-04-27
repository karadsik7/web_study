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
	function validate(f){
		if(f.title.value == ""){
			alert("제목을 입력하세요.");
			f.title.focus();
			return;
		}else if(f.name.value == ""){
			alert("이름을 입력하세요.");
			f.name.focus();
			return;
		}else if(f.content.value == ""){
			alert("내용을 입력하세요.");
			f.content.focus();
			return;
		}
		f.submit();
	}
</script>
</head>
<body>
<div class="container">
	<div class="header">
		<h1 class="title text_center">자유게시판</h1>
		<h2 class="text_center" style="margin: 20px auto; color: navy;">글쓰기</h2>
	</div>
	<div class="body">
	<form action="${pageContext.request.contextPath}/board/add" method="post">
		<table class="board-view">
			<tr>
				<th width="30%">제목</th>
				<td><input type="text" name="title"/></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="2" class="content">
					<textarea name="content"></textarea>
				</td>
			</tr>
		</table>
		<div class="buttons">
			<button type="button" onclick="validate(this.form);">등록</button>
		</div>
	</form>
	</div>
	<div class="footer">
	
	</div>
</div>
</body>
</html>