package com.inc.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.CartDao;

@WebServlet("/cart/insert")
public class CartInsertServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		String u_id = request.getParameter("u_id");
		
		Map<String, Object> idMap = new HashMap<>();
		idMap.put("p_id", p_id);
		idMap.put("u_id", u_id);
		
		//cart테이블에 존재하는지 확인
		int count = CartDao.getInstance().getCount(idMap);
		if(count == 0) {
			//존재하지 않을 시 cart테이블에 추가
			CartDao.getInstance().insert(idMap);
			response.getWriter().print("y");
		}else {
			//추가x 메세지 출력
			response.getWriter().print("n");
		}
		
	}
}
