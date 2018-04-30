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
		if(confirm("정말로 삭제하시겠습니까?")){
			$.ajax({
				"url" : "${pageContext.request.contextPath}/board/del",
				"type" : "post",
				"data" : {"id" : id},
				"success" : function(data){
					alert("삭제가 완료됐습니다. 메인페이지로 이동합니다.");
					location.href = '${pageContext.request.contextPath}/board/list';
				}
			})
		}
	}
	
	function mod(id){
		if(confirm("수정하시겠습니까?")){
			location.href = '${pageContext.request.contextPath}/board/modify?id='+id;
		}
	}
</script>
</head>
<body>
<div class="container">
	<div class="header">
		<h1 class="title text_center">자유게시판</h1>
	</div>
	<div class="body">
		<table class="board-view">
			<tr>
				<th width="30%">제목</th>
				<td>${board.title }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${board.name }</td>
			</tr>
			<tr>
				<th></th>
				<td colspan="2" class="content">${board.content }</td>
			</tr>
		</table>
		<div class="buttons">
			<button type="button" style="text-align: right" 
			onclick="location.href='${pageContext.request.contextPath}/board/list?page=${param.page }'">목록</button>
			<button type="button" style="text-align: right" 
			onclick="mod(${board.id});">수정</button>
			<button type="button" style="text-align: right" 
			onclick="del(${board.id});">삭제</button>
		</div>
	</div>
	
	<div class="footer">
	
	</div>
</div>
</body>
</html>