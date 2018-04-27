package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ProductDao;
import com.inc.vo.ProductVo;

@WebServlet("/product/view")
public class ProductViewServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		ProductVo pvo = ProductDao.getInstance().selectOne(id);
		request.setAttribute("pvo", pvo);
		request.getRequestDispatcher("/views/product/view.jsp").forward(request, response);
		
	}
}
