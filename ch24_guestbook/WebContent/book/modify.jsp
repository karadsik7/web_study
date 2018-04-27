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

</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	function check(){
		if($("#name").val() == ""){
			$("#name").focus();
			alert("이름을 입력하세요");
			return;
		}
		if($('#password').val() == ""){
			$('#password').val('${bvo.password }'); 
		}
		
		$("#mod_form").submit();
	}
</script>
</head>
<body>
	<div class="main">
		<div class="header">
			<h1 class="title">UPDATE POST</h1>
		</div>
		<hr />
		<div class="content">
			<form action="${pageContext.request.contextPath}/book/modify" method="post" id="mod_form">
			<input type="hidden" name="id" value = "${bvo.id }"/>
				<table>
					<tr>
						<th>Name</th>
						<td>
							<input id="name" type="text" name="writer" placeholder="이름을 입력하세요."
							value = "${bvo.writer }"/>
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
							cols="50" rows="20">${bvo.msg }</textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<hr />
		<div class="footer text_center">
			<button class="smaLL" type="button" onclick="check();">수정</button>
			<button class="smaLL" type="button" onclick="history.back();">취소</button>
		</div>
	</div>
</body>
</html>