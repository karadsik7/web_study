package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.MemberDao;
import com.inc.vo.MemberVo;

@WebServlet("/member/signin")
public class SignInServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("signin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		
		MemberVo mvo = MemberDao.getInstance().login(id);
		
		if(mvo == null) {
			//존재x아이디
			request.setAttribute("msg", "존재하지 않는 아이디입니다.");
			request.setAttribute("url", request.getContextPath()+"/member/signin");
			request.getRequestDispatcher("../alert.jsp").forward(request, response);
		}else if(!mvo.getPassword().equals(password)) {
			//비밀번호 불일치
			request.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
			request.setAttribute("url", request.getContextPath()+"/member/signin");
			request.getRequestDispatcher("../alert.jsp").forward(request, response);
		}else {
			//로그인
			//세션에다가 아이디만 집어넣으면 됨
			//이름도 띄우고 싶으므로 세션에 이름도 보낸다
			//하지만 세션에 너무 많은 정보가 저장되면 서버에 부담이 되므로 너무 많은 정보 저장x
			request.getSession().setAttribute("id", mvo.getId());
			request.getSession().setAttribute("name", mvo.getName());
			response.sendRedirect(request.getContextPath()+"/main");
		}
		
		
	}

}

