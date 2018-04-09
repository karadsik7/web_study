package com.inc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pwd = "1111";
		
		//connection은 데이터베이스와의 연결 객체
		Connection conn = null;
		//statement는 구문(쿼리)객체
		Statement stmt = null;
		//rs는 결과객체(오라클에서 쿼리를 처리한 결과데이터)
		ResultSet rs = null;
		
		try {
			//오라클과 연결
			conn = DriverManager.getConnection(url, user, pwd);
			//빈 구문객체 생성
			stmt = conn.createStatement();
			//구문객체에 집어넣을 쿼리 작성
			String query = "select * from employees";
			//구문 전달 및 데이터 수신
			rs = stmt.executeQuery(query);
			
			//데이터 출력
			//rs.next는 더이상 찾을 튜플이 없을때까지 지속 없으면 false반환
			while(rs.next()) {
				//데이터베이스의 자료형과 일치시키고 컬럼명을 넘겨준다.
				//단, 파라미터의 컬럼명은 반드시 테이블의 컬럼명과 일치해야 한다.
				int employee_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				int salary = rs.getInt("salary");
				System.out.printf("%d\t\t%s\t\t%d\n", employee_id, first_name, salary);
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
