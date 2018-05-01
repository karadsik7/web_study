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
		//검색옵션
		request.setCharacterEncoding("utf-8");
		String option = request.getParameter("option");
		String text = request.getParameter("text");
		
		String searchParam = "";
		if(option != null && !option.equals("all")) {
			searchParam = "&option="+option+"&text="+text;
		}
		
		
		//페이징
		int nowPage = 1;
		String page = request.getParameter("page");
		if(page != null && !page.equals("")) {
			nowPage = Integer.parseInt(page);
		}
		int maxCountOfOneList = 5;
		int maxCountOfOnePage = 3;
		
		int startRownum = (nowPage - 1) * maxCountOfOneList + 1;
		int endRownum = startRownum + (maxCountOfOneList - 1);
		
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("start", startRownum);
		searchMap.put("end", endRownum);
		searchMap.put("option", option);
		searchMap.put("text", text);
		
		List<Board> boardList = BoardDao.getInstance().selectList(searchMap);
		
		int totalCount = BoardDao.getInstance().totalCount(searchMap);
		String paging = Paging.getInstance()
				.getPaging(request.getContextPath()+"/board/list",
						nowPage, totalCount, maxCountOfOneList, maxCountOfOnePage, searchParam);  
		
		
		request.setAttribute("paging", paging);
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher("/views/board/list.jsp").forward(request, response);
	}
}

