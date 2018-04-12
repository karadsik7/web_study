package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ScoreDao;
import com.inc.vo.ScoreVo;

@WebServlet("/score/modify")
public class ScoreModifyServlet extends HttpServlet {
	
	//서비스를 오버라이딩 안하면 아래 주석처리한 코드가 자동으로 처리됨

	/*protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getMethod().equals("GET")) {
			doGet(request, response);
		}else {
			doPost(request, response);
		}

	}*/
	
	//데이터 전송 방식이 겟이냐 포스트냐에 따라서 다른 로직 작성 가능하다.
	//이렇게하면 url(서블릿)을 하나 더 만들어야하는 단점을 보완가능
	
	//겟방식으로 요청이 오면 view를 띄우고
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ScoreVo svo = ScoreDao.getInstance().selectOne(id);
		
		request.setAttribute("svo", svo);
		//포워드는 경로적을때 무조건 모듈패스 생략
		request.getRequestDispatcher("/views/score_update_view.jsp")
		.forward(request, response);
		
	}
	//데이터를 실제로 db로 수정하기위해 post방식으로 데이터를 보내면 여기서 처리하게 됨
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		
		ScoreVo svo = new ScoreVo();
		svo.setId(id);
		svo.setName(name);
		svo.setKor(kor);
		svo.setEng(eng);
		svo.setMath(math);
		
		ScoreDao scoreDao = ScoreDao.getInstance();
		scoreDao.modify(svo);
		
		//리다이렉트는 브라우저에게 절대경로상에서는 경로를 알려줘야하므로 모듈패스 넣어줘야함 
		response.sendRedirect("/ch18_scoreModel2/score/list");
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(math);
	}

}
