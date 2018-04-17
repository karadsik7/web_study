<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<style>
button.smaLL{
	width: 30%;
}
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

#comment{
    border-bottom: none;
}

#dualDiv{
	display: none;
}

</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	function check(){
		if($("#name").val() == ""){
			$("#name").focus();
			alert("이름을 입력하세요");
			return;
		}
		if($("#password").val() == ""){
			$("#password").focus();
			alert("비밀번호를 입력하세요");
			return;
		}
		$("#add_form").submit();
	}
	
	function dualCheck(){
		//버튼 눌렀을 때 똑같은 작성자의 방명록이 존재하면 중복확인해서 중복된 이름이라고만 알려주기
		var writer = $("#name").val();
		
		var xhr = new XMLHttpRequest();
		var param = "writer="+writer;
		var method = "POST";
		var url = "${pageContext.request.contextPath}/book/writercheck"
		
		xhr.open(method, url, true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var check = xhr.responseText;
				if(check == 404404){
					alert("DB 오류입니다. 관리자에게 문의하세요.");
				}else if(check == 0){
					$("#dualDiv").css("display", "block");
					$("#dualDiv").html("<h5>첫 방명록이시군요!</h5>");
					$("#dualDiv").css("color", "blue");
				}else{
					$("#dualDiv").css("display", "block");
					$("#dualDiv").html("<h5>이미 방명록을 남기셨네요.</h5>");
					$("#dualDiv").css("color", "red");
				}
			}
		}
		xhr.send(param);
		
	}
</script>

</head>
<body>
	<div class="main">
		<div class="header">
			<h1 class="title">ADD POST</h1>
		</div>
		<hr />
		<div class="content">
			<form action="${pageContext.request.contextPath}/book/add" method="post" id="add_form">
				<table>
					<tr>
						<th>Name</th>
						<td>
							<input id="name" type="text" name="name" placeholder="이름을 입력하세요."/>
							<button type="button" onclick="dualCheck();">중복 확인</button>
							<div id="dualDiv"></div>
						</td>
					</tr>
					<tr>
						<th>Password</th>
						<td>
							<input id="password" type="password" name="password" placeholder="비밀번호를 입력하세요."/>
						</td>
					</tr>
					<tr>
						<th colspan="2" id="comment">Comment</th>
					</tr>
					<tr>
						<td colspan="2">
							<textarea name="msg" placeholder="내용을 입력해주세요."
							cols="50" rows="20"></textarea>
							
						</td>
					</tr>
				</table>
			</form>
		</div>
		<hr />
		<div class="footer text_center">
			<button class="smaLL" type="button" onclick="check();">등록</button>
			<button class="smaLL" type="button" onclick="history.back();">취소</button>
		</div>
	</div>
</body>
</html>