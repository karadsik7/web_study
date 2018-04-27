package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.CartDao;

@WebServlet("/cart/del")
public class CartDelServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String u_id = request.getParameter("u_id");
		CartDao.getInstance().delete(id);
		
		response.sendRedirect(request.getContextPath() + "/cart/list?u_id="+ u_id);
		
	}
}
