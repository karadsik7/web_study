package com.inc.servlet.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ReplyDao;
import com.inc.vo.Reply;

@WebServlet("/reply/add")
public class ReplyAddServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		int b_id = Integer.parseInt(request.getParameter("b_id"));
		
		Reply reply = new Reply();
		reply.setB_id(b_id);
		reply.setContent(content);
		reply.setName(name);
		
		ReplyDao.getInstance().add(reply);
		response.sendRedirect(request.getContextPath() + "/board/view?id="+b_id);
		
	}
}
