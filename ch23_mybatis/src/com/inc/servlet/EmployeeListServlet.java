package com.inc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.EmpDao;
import com.inc.vo.EmpVo;

@WebServlet("/emp/list")
public class EmployeeListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<EmpVo> empList = EmpDao.getInstance().selectList();
		
		request.setAttribute("empList", empList);
		request.getRequestDispatcher("/emp_list.jsp").forward(request, response);
		
	}
}

