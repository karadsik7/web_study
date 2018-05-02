package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.util.SearchUtil;
import com.inc.vo.ProductVo;

@WebServlet("/product/list")
public class ProductListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchText = request.getParameter("searchText");
		if(searchText == null) {
			searchText = "컴퓨터";
		}
		int start = 1;
		int display = 10;
		
		List<ProductVo> productList = SearchUtil.search(searchText, start, display);
		
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/product/list.jsp").forward(request, response);
	}
}
