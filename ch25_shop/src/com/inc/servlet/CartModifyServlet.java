package com.inc.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.CartDao;
import com.inc.vo.CartVo;

@WebServlet("/cart/modify")
public class CartModifyServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int count = Integer.parseInt(request.getParameter("count"));
		int id = Integer.parseInt(request.getParameter("id"));
		String u_id = request.getParameter("u_id");
		CartVo cvo = new CartVo();
		cvo.setId(id);
		cvo.setCount(count);
		System.out.println(cvo.getId());
		System.out.println(cvo.getCount());
		
		CartDao.getInstance().modify(cvo);
		
		response.sendRedirect(request.getContextPath() + "/cart/list?u_id=" + u_id);
	}
}
