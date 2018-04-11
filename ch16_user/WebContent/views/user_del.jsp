<%@page import="com.inc.dao.UserDao"%>
<%@page import="com.inc.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//겟방식으로 넘겨받았으므로 받을 수 있다.
	//DB에서 삭제할때 필요한건 id만 있으면 충분하므로 get방식을 씀
	String id = request.getParameter("id");
	//여기까지 왔으면 Dao를 거쳐서 db에서 삭제해야하므로 vo로 포장해주고 넘겨주는 작업을 한다
	UserVo uvo = new UserVo();
	uvo.setId(id);
	
	UserDao userDao = UserDao.getInstance();
	userDao.del(uvo);
	
	response.sendRedirect("user_list.jsp");
%>