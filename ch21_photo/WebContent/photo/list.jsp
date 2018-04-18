<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/photo.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	function del(id, filename){
		console.log(filename);
		$.ajax({
			"type" : "post",
			"url" : "passwordCheck",
			"data" : {"id" : id},
			"success" : function(password){
				if(password == prompt("패스워드를 입력하세요.")){
					location.href = "delete?id="+id+"&filename="+filename;
				}else{
					alert("땡!");
				}
			}
		})
	}
	
	function down(filename){
		location.href = "${pageContext.request.contextPath}/download?filename=" + filename;
	}
</script>
</head>
<body>
	<div class="main">
		<div class="header">
			<h1 class="text_center">Photo Gallary</h1>
			<div class="text_center">
				<button type="button" onclick="location.href = 'insert'">추가</button>
			</div>
		</div>
		<c:if test="${empty photoList }">
				<div class="text_center">
					등록한 사진이 없습니다.
				</div>
			</c:if>
		<div class="content">
			<c:forEach var="pvo" items="${photoList }">
			<div class="photo">
				<img src="../upload/${pvo.filename }" alt="" />
				<div class="title text_center">
					${pvo.title } | ${pvo.regdate }
				</div>
				<div class="text_center">
					<button type="button" onclick="down('${pvo.filename}');">다운로드</button>
					<button type="button" onclick="del(${pvo.id}, '${pvo.filename }');">삭제</button>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>