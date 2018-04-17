<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.main{
	width : 500px;
	margin : 0 auto;
}
#video_poketmon{
	width: 500px;
	height: 320px;
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(function(){
		var url = "${pageContext.request.contextPath}/video/list";
		var obj = {
				"url" : url,
				"method":"POST",
				"success" : function(data){
					data = eval(data);
					for(var video of data){
						var option = $("<option></option>");
						option.html(video.title);
						option.val(video.path);
						
						$("#video_select").append(option);
					}
					
				}
		};
		$.ajax(obj);
	})
	
	function play(){
		var path = $("#video_select").val();
		if(path == ""){
			return;
		}
		
		$("#video_poketmon").attr("src", path);
		$("#video_poketmon").get(0).play();
		
	}
	
</script>
</head>
<body>
	<div class="main">
		<div class="content">
			비디오 목록
			<select id="video_select" onchange = play();>
			<option value="">재생할 비디오를 선택해주세요</option>
			</select>
			<hr />
			<video id="video_poketmon" src="" controls></video>
		</div>
	</div>
</body>
</html>