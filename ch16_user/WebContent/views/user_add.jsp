<%@page import="com.inc.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//1. 한글이 깨지지 않도록 인코딩방식을 설정한다.
	request.setCharacterEncoding("utf-8");

	//2. 전송할 자료를 자료형과 앞의 html의 input의 name속성과 getParameter의 파라미터와 일치하게
	//맞춰서 변수에 넣는다.
	//(자료형이 int인 경우 ParseInt 메서드를 사용한다.)
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	
	System.out.println(id);
	System.out.println(name);
	
	
	//3. Vo에 형태에 맞게 넣어준다
	
	UserVo uvo = new UserVo();
	uvo.setId(id);
	uvo.setName(name);
	
	
	//4. 나머진 다음시간에
	
	


%>