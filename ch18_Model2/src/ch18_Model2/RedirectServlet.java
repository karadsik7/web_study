package ch18_Model2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	//리다이렉트 방식 : 서블릿과 클라이언트간의 요청과 view.jsp와 클라이언트간 요청 두개가 존재하기 때문에
	//서블릿의 리퀘스트 데이터가, jsp와 직접연결이 아니기 때문에 view.jsp의 리퀘스트 스코프가 null임
	//리다이렉트를 쓰는 경우 : 데이터베이스의 갱신이 일어나야 할 때
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int result = num1 + num2;
		
		request.setAttribute("result", result);
		response.sendRedirect("view.jsp");
		
	}

}
