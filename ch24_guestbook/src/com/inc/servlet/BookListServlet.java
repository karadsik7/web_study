package com.inc.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.BookDao;
import com.inc.vo.BookVo;

@WebServlet("/book/list")
public class BookListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String search_option = request.getParameter("search_option");
		String search_text = request.getParameter("search_text");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("search_option", search_option);
		searchMap.put("search_text", search_text);
		
		List<BookVo> bookList = BookDao.getInstance().selectList(searchMap);
		
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}

}
