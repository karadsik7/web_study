package com.inc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ScoreDao;
import com.inc.vo.ScoreVo;

//서블릿 url 명명 규칙 : 역할이 나타나도록 명명할것
@WebServlet("/score/list")
public class ScoreListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ScoreDao scoreDao = ScoreDao.getInstance();
		ArrayList<ScoreVo> scoreList = scoreDao.selectList();
		//요청한 jsp로 보내줄 객체 생성
		request.setAttribute("scoreList", scoreList);
		//포워드방식으로 보냄
		request.getRequestDispatcher("../views/score_list.jsp").forward(request, response);
		
		
	}

	

}
