package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.LocDao;
import com.inc.vo.LocVo;

@WebServlet("/loc/list")
public class LocationListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<LocVo> locList = LocDao.getInstance().selectList();
		request.setAttribute("locList", locList);
		request.getRequestDispatcher("/loc_list.jsp").forward(request, response);
		
	}
}
