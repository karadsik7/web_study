package com.inc.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.BoardDao;
import com.inc.vo.Board;

@WebServlet("/board/modify")
public class BoardModServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Board board = BoardDao.getInstance().selectOne(id);
		request.setAttribute("board", board);
		request.getRequestDispatcher("/views/board/modify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println(id);
		System.out.println(name);
		System.out.println(title);
		System.out.println(content);
		
		Board board = new Board();
		board.setId(id);
		board.setName(name);
		board.setTitle(title);
		board.setContent(content);
		
		BoardDao.getInstance().modify(board);
		response.sendRedirect(request.getContextPath() + "/board/view?id="+id);
	}

}
