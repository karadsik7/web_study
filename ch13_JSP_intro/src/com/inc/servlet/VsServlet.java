package com.inc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vs")
public class VsServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>nogada ggamji</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>여기는 Servlet</h1>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>Servlet</td>");
		out.println("<td>VS</td>");
		out.println("<td>JSP</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

