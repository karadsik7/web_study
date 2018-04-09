package com.inc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.util.DbConnectorJNDI;

import oracle.jdbc.driver.OracleDriver;

@WebServlet("")
public class JdbcServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		//서블릿에선 오라클 드라이브 로더를 클래스 영역에 최초로 로딩시켜줘야 인식함
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			new OracleDriver();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DbConnectorJNDI.getConnection();
			stmt = conn.createStatement();
			String query = "select * from employees";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int empl_id = rs.getInt("employee_id");
				String name = rs.getString("first_name");
				int salary = rs.getInt("salary");
				response.getWriter().printf("%d\t\t%s\t\t%d\n", empl_id, name, salary);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
