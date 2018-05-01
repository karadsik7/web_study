package com.inc.servlet.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.BoardDao;
import com.inc.vo.Board;

@WebServlet("/board/comment")
public class BoardCommentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Board board = BoardDao.getInstance().selectOne(id);
		request.setAttribute("board", board);
		request.getRequestDispatcher("/views/board/comment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int reference_id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		Board original_board = BoardDao.getInstance().selectOne(reference_id);
		
		int ref = original_board.getRef();
		int step = original_board.getStep() + 1;
		int depth = original_board.getDepth() + 1;
		
		//답글 추가
		Board board = new Board();
		board.setTitle(title);
		board.setName(name);
		board.setContent(content);
		board.setRef(ref);
		board.setStep(step);
		board.setDepth(depth);
		board.setIp(request.getRemoteAddr());
		
		
		//답글 step 조정 (step을 기준으로 정렬하는데 중간에 다른 답글이 끼일 경우 아래 답글은 step을 1 증가시켜야함)
		BoardDao.getInstance().updateStep(board);
		
		BoardDao.getInstance().comment(board);
		
		response.sendRedirect(request.getContextPath() + "/board/list");
	}

}
