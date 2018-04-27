package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.CartDao;
import com.inc.vo.CartVo;


@WebServlet("/cart/list")
public class CartListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String u_id = request.getParameter("u_id");
		List<CartVo> cartList = CartDao.getInstance().cartList(u_id);
		int total = 0;
		for(CartVo cvo : cartList) {
			double price = cvo.getCount() * (1 - cvo.getPvo().getRetail_pct()) * cvo.getPvo().getPrice();
			price = Math.round(price);
			total += price;
		}
		
		request.setAttribute("total", total);
		request.setAttribute("cartList", cartList);
		request.getRequestDispatcher("/views/cart/list.jsp").forward(request, response);
		 
		
	}
}

