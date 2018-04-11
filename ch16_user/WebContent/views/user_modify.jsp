<%@page import="com.inc.dao.UserDao"%>
<%@page import="com.inc.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 여기선 넘겨받은 값을 통해서 dao에 보내주고 db에 적용시키면 된다. -->

<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	
	UserVo uvo = new UserVo();
	uvo.setId(id);
	uvo.setName(name);
	
	UserDao userDao = UserDao.getInstance();
	userDao.modify(uvo);
	
	response.sendRedirect("user_list.jsp");
	
	
	
	
	
%>