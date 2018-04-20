package com.inc.serlvet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.vo.UserVo;

@WebServlet("/session/get")
public class SessionGetServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//세션은 브라우저에 정보가 저장되어있기 때문에 굳이 데이터를 받아오는 과정은 할 필요가 없음
		UserVo uvo = (UserVo)(request.getSession().getAttribute("uvo"));
		System.out.println(uvo.getId());
		System.out.println(uvo.getName());
		System.out.println(uvo.getPassword());
		
		request.getRequestDispatcher("get.jsp").forward(request, response);
		
	}
}

