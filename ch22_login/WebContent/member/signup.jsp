<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	var dualChecked = false;

	function pwdCheck(){
		var password = $("#password").val();
		var password_check = $("#password_check").val();
		if(password_check == ""){
			$("#alert").html("");
		}else if(password == password_check){
			$("#alert").html("<h4>correct<h4>");
			$("#alert").css("color", "blue");
		}else{
			$("#alert").html("<h4>Write the password again to match<h4>");
			$("#alert").css("color", "red");
		}
	}
	
	function idCheck(){
		var id = $("#id").val();
		$.ajax({
			"url" : "dualCheck",
			"type" : "post",
			"data" : {"id" : id},
			"success" : function(data){
				if(data == 'y'){
					alert("중복된 아이디 입니다.");
				}else if(data == 'n'){
					alert("사용 가능한 아이디입니다.");
					dualChecked = true;
				}else{
					alert("잠시 후 다시 시도해주세요.");
				}
			}
		});
	}
	
	function validate(form){
		
		//console.log(form.name.value);
		
		if(form.id.value == ""){
			alert("아이디를 입력하세요.")
			form.id.focus();
			return;
		}else if(form.password.value == ""){
			alert("패스워드를 입력하세요.")
			form.password.focus();
			return;
		}else if($("#alert").text() != "correct"){
			alert("비밀번호가 일치하는지 확인하세요.");
			form.password_check.focus();
			return;
		}else if(form.name.value == ""){
			alert("이름을 입력하세요.");
			form.name.focus();
			return;
		}else if(dualChecked == false){
			alert("아이디 중복 확인을 하세요.")
			form.name.focus();
			return;
		}
		
		form.submit();
	}
	
</script>
</head>
<body>
	<div class="main">
		<div class="header">
			<!-- 특정한 중복 태그들을 외부의 1개 파일로 처리 -->
			<!-- 2. 지시어 include 사용 -->
			<%@ include file="../menu.jsp" %>
			<h1 class="title text_center">Sign Up</h1>
		</div>
		<div class="content">
			<form action="${pageContext.request.contextPath }/member/signup" method="post" id="form">
				<table class="insert_form">
					<tr>
						<th>ID</th>
						<td>
						<input type="text" name="id" id="id" placeholder="최대 15글자" onkeyup="dualChecked = false;"/>
						<button type="button" onclick="idCheck();">중복 확인</button>
						</td>
					</tr>
					<tr>
						<th>Password</th>
						<td><input id="password" type="password" name="password" onkeyup="pwdCheck();"/></td>
					</tr>
					<tr>
						<th>Password Check</th>
						<td>
							<input type="password" id="password_check" onkeyup="pwdCheck();"/><br />
							<span id="alert"></span>
						</td>
					</tr>
					<tr>
						<th>Name</th>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<th>Gender</th>
						<td>
							<input type="radio" name="gender" value="m" checked />Male
							<input type="radio" name="gender" value="f" />Female
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text_center">
							<button type="button" onclick="validate(this.form);">Send</button>
							<button type="button" onclick="location.href='../main';">Cancel</button>
						</td>
						
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>