package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ScoreDao;

//서블릿 url 명명 규칙 : 역할이 나타나도록 명명할것
@WebServlet("/score/delete")
public class ScoreDeleteServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		ScoreDao scoreDao = ScoreDao.getInstance();
		scoreDao.delete(id);
		
		response.sendRedirect("/ch18_scoreModel2/score/list");
		
	}

	

}
