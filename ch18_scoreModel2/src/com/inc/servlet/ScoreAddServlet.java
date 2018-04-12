package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ScoreDao;
import com.inc.vo.ScoreVo;

@WebServlet("/score/add")
public class ScoreAddServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	

		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		
		System.out.println(name);
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(math);
		
		ScoreVo svo = new ScoreVo();
		svo.setName(name);
		svo.setKor(kor);
		svo.setEng(eng);
		svo.setMath(math);
		
		ScoreDao scoreDao = ScoreDao.getInstance();
		scoreDao.insert(svo);
		
		response.sendRedirect("/ch18_scoreModel2/score/list");
		
	}

	
}

