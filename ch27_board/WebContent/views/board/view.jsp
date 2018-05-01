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
	
	function replySend(f){
		if(/^.{2,10}$/.test(f.name.value) == false){
			alert("이름은 2글자이상 10글자 이하로 작성해야합니다.");
			f.name.focus();
			return;
		}else if(/^.{2,100}$/.test(f.content.value) == false){
			alert("댓글 내용은 2글자 이상 100글자 이하로만 작성해야 합니다.");
			f.content.focus();
			return;
		}
		f.action = "${pageContext.request.contextPath}/reply/add";
		f.submit();
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
			<button type="button" onclick="location.href='${pageContext.request.contextPath}/board/comment?id=${board.id }'">답글</button>
			<button type="button" style="text-align: right" 
			onclick="del(${board.id});">삭제</button>
		</div>
	</div>
	
	<div class="footer">
		<div class="reply">
			<form method="post">
				<input type="hidden" name="b_id" value="${board.id }"/>
				<table class="board-view">
					<caption>:::comment:::</caption>
					<tr>
						<th width="30%">이름</th>
						<td><input type="text" name="name"/></td>
					</tr>
					<tr>
						<th width="30%">내용</th>
						<td><input type="text" name="content"/></td>
					</tr>
					<tr>
						<th>
							<button type="button" onclick="replySend(this.form);">댓글등록</button>
						</th>
					</tr>
				</table>
			</form>
			<table class="board-view">
			<c:if test="${empty board.replyList}">
				<tr>
					<th colspan="2">
						댓글이 존재하지 않습니다.
					</th>				
				</tr>
			</c:if>
			<c:forEach var="reply" items="${board.replyList }">
				<tr>
					<th width="30%">${reply.name }</th>
					<td>${reply.content }</td>
				</tr>
			</c:forEach>
			</table>
			
		</div>
	</div>
</div>
</body>
</html>