package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ProductDao;
import com.inc.vo.ProductVo;

@WebServlet("/product/list")
public class ProductListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String category = request.getParameter("category");
		
		List<ProductVo> productList = ProductDao.getInstance().productList(category);
		
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/views/product/list.jsp").forward(request, response);
	}
}

