package ch18_Model2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class FowardServlet extends HttpServlet {
	//포워드 방식과 리다이렉트 방식 비교
	//포워드방식 : dispatcher를 통해서 연결(요청)을 유지하며 데이터를 넘겨주기 때문에 request스코프에
	//값이 유지되며 들어감
	
	//포워드방식
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int result = num1 + num2;
		
		//리퀘스트 객체에 키값과 데이터를 넣어줌
		request.setAttribute("result", result);
		//view.jsp로 리퀘스트디스패처 객체를 통해 전달
		RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
		dispatcher.forward(request, response);
	}

}
