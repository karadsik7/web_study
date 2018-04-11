<%@page import="com.inc.dao.ScoreDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	ScoreDao scoreDao = ScoreDao.getInstance();
	scoreDao.delete(id);
	
	response.sendRedirect("/ch16_score/views/score_list.jsp");
	
%>