<%@page import="com.inc.dao.ScoreDao"%>
<%@page import="com.inc.vo.ScoreVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	request.setCharacterEncoding("utf-8");
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int math = Integer.parseInt(request.getParameter("math"));
	
	ScoreVo svo = new ScoreVo();
	svo.setId(id);
	svo.setName(name);
	svo.setKor(kor);
	svo.setEng(eng);
	svo.setMath(math);
	
	ScoreDao scoreDao = ScoreDao.getInstance();
	scoreDao.modify(svo);
	
	response.sendRedirect("/ch16_score/views/score_list.jsp");
	
	System.out.println(id);
	System.out.println(name);
	System.out.println(kor);
	System.out.println(eng);
	System.out.println(math);
%>