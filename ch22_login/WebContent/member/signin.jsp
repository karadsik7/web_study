<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	//유효성 검사
	function validate(form){
		if(form.id.value == ""){
			alert("아이디를 입력하세요");
			form.id.focus();
			return;
		}else if(form.password.value == ""){
			alert("패스워드를 입력하세요.");
			form.password.focus();
			return;
		}
		form.submit();
	}
</script>
</head>
<body>
	<div class="main">
		<div class="header">
			<jsp:include page="../menu.jsp" />
			<h1 class="title text_center">LOGIN Page</h1>
		</div>
		<div class="content">
		<form action="${pageContext.request.contextPath}/member/signin" method="post">
			<table class="insert_form">
				<tr>
					<th>ID</th>
					<td>
						<input type="text" name="id" id="id"/>
					</td>
				</tr>
				<tr>
					<th>Password</th>
					<td>
						<input type="password" name="password" id="password" />
					</td>
				</tr>
				<tr>
					<td colspan="2" class="text_center">
						<button type="button" onclick="validate(this.form);">Log In!</button>
						<button type="button" onclick="location.href='../main'">Cancel</button>
					</td>
				</tr>
			</table>	
		</form>
		</div>
	</div>
</body>
</html>