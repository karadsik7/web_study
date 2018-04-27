package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.DeptDao;
import com.inc.vo.DeptVo;

@WebServlet("/dept/list2")
public class DepartmentList2Servlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<DeptVo> deptList = DeptDao.getInstance().selectList2();
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/dept_loc_list.jsp").forward(request, response);
	}
}
