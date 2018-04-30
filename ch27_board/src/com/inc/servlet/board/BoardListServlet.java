package com.inc.servlet.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.BoardDao;
import com.inc.util.Paging;
import com.inc.vo.Board;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int nowPage = 1;
		String page = request.getParameter("page");
		if(page != null && !page.equals("")) {
			nowPage = Integer.parseInt(page);
		}
		int maxCountOfOneList = 3;
		int maxCountOfOnePage = 5;
		
		int startRownum = (nowPage - 1) * maxCountOfOneList + 1;
		int endRownum = startRownum + (maxCountOfOneList - 1);
		
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("start", startRownum);
		searchMap.put("end", endRownum);
		
		List<Board> boardList = BoardDao.getInstance().selectList(searchMap);
		
		int totalCount = BoardDao.getInstance().totalCount();
		String paging = Paging.getInstance()
				.getPaging(request.getContextPath()+"/board/list",
						nowPage, totalCount, maxCountOfOneList, maxCountOfOnePage);  
		
		request.setAttribute("paging", paging);
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher("/views/board/list.jsp").forward(request, response);
	}
}

