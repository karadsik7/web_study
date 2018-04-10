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
	
}
