package com.inc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.inc.util.DbCloser;
import com.inc.util.DbConnector;
import com.inc.vo.UserVo;


public class UserDao {

	//DB연결 및 데이터 가져오기
	
	//1. 우선 가져올 데이터의 배열을 메서드화
	//3. 이 클래스에는 참조하는 인스턴스 변수가 없는 메서드만 있는 클래스이고
	// 다중스레드 환경에서의 독립성을 어느정도 보장하기 위해 싱글턴패턴으로 바꾼다
	
	private static UserDao single;
	
	private UserDao() {};
	
	public static UserDao getInstance() {
		if(single == null) {
			single = new UserDao();
		}
		return single;
	}
	
	
	public ArrayList<UserVo> selectList(){
		//1) 배열을 선언 및 초기화하고 DB와 연결
		ArrayList<UserVo> userList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from users");
			
			//2) db로부터 응답받은 데이터를 변수에 집어넣은 후 Vo 세터로 객체에 데이터를 넣고
			//  그 객체를 다시 userList 배열에 넣는다. (반복문으로 테이블이 끝날때까지 반복)
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				
				UserVo uvo = new UserVo();
				uvo.setId(id);
				uvo.setName(name);

				userList.add(uvo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//커넥션 반환을 꼭 시켜줘야함
			DbCloser.close(conn, stmt, rs);
		}
		
		//2. db에서 받아온 데이터를 리턴
		
		return userList;
	}
	
	public void insert(UserVo uvo) {
		//1. db에 삽입하기 위해선 커넥션부터 정의한다.
		Connection conn = null;
		Statement stmt = null;
		//2. resultset은 필요없을 것
		
		conn = DbConnector.getInstance().getConnection();
		try {
			stmt = conn.createStatement();
		//3. DB에 삽입할 쿼리문을 작성하고 보내준다.
			String query = String.format("insert into users values('%s', '%s')",
					uvo.getId(), uvo.getName());
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//커넥션을 닫는다.
			DbCloser.close(conn, stmt, null);
		}
	}
	
	public void del(UserVo uvo) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			String query = String.format("delete from users where id = '%s'", uvo.getId());
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//커넥션을 닫는다.
			DbCloser.close(conn, stmt, null);
		}
	}
	
	public UserVo oneView(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		UserVo uvo = new UserVo();
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			String query = String.format("select * from users where id = '%s'", id);
			rs = stmt.executeQuery(query);
			//rs를 통해 다시 Vo로 묶어서 modify_view로 날려준다.
			//rs.next를 안하면 db의 첫 포인터가 0행을 가리키기때문에 널값을 반환하므로 주의
			rs.next();
			uvo.setId(rs.getString("id"));
			uvo.setName(rs.getString("name"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//커넥션을 닫는다.
			DbCloser.close(conn, stmt, rs);
		}
		return uvo;
	}
	
	public void modify(UserVo uvo) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			String query = String.format("update users set name = '%s' where id = '%s'", uvo.getName(), uvo.getId());
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//커넥션을 닫는다.
			DbCloser.close(conn, stmt, null);
		}
	}
	
}
