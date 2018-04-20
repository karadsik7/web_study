package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.MemberDao;
import com.inc.vo.MemberVo;

@WebServlet("/member/signup")
public class SignUpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
		MemberVo mvo = new MemberVo();
		mvo.setId(id);
		mvo.setPassword(password);
		mvo.setName(name);
		mvo.setGender(gender);
		
		MemberDao.getInstance().insert(mvo);
		request.setAttribute("msg", "회원가입이 정상적으로 완료됐습니다. 메인페이지로 이동합니다.");
		request.setAttribute("url", "../main");
		request.getRequestDispatcher("../alert.jsp").forward(request, response);
		
		
	}

}
