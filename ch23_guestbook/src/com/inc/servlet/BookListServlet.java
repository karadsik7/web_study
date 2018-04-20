package com.inc.servlet;

import java.io.IOException;
import java.util.List;

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
		List<BookVo> bookList = BookDao.getInstance().selectList();
		
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}

}
