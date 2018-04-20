package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.MemberDao;

@WebServlet("/member/dualCheck")
public class DualCheckServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String result = MemberDao.getInstance().dualCheck(id);
		response.setContentType("text/plain; utf-8");
		if(id.equals(result)) {
			response.getWriter().print("y");
		}else {
			response.getWriter().print("n");
		}
		
		
	}
}
