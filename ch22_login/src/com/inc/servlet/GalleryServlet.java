package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gallery")
public class GalleryServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//로그인체크
		if(request.getSession().getAttribute("id") == null) {
			request.setAttribute("msg", "로그인 후 이용해주세요.");
			request.setAttribute("url", request.getContextPath() + "/member/signin");
			request.getRequestDispatcher("/alert.jsp").forward(request, response);
			//포워드는 한번만 할 수 있으므로 반드시 리턴해야함
			return;
		}
		//세션이동
		request.getRequestDispatcher("/gallery.jsp").forward(request, response);
	}
}
