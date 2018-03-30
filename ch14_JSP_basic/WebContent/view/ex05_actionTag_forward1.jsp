<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String name = request.getParameter("name");
	String msg = name + "님 안녕하세요?";
	//request객체에 포워딩할 내용 담기
	request.setAttribute("msg", msg);
	/* request.getRequestDispatcher("ex05_actionTag_forward2.jsp").forward(request, response); */	
%>


<jsp:forward page="ex05_actionTag_forward2.jsp"></jsp:forward>