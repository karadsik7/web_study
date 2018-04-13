package com.inc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.inc.util.DbCloser;
import com.inc.util.DbConnector;
import com.inc.vo.BookVo;

public class BookDao {
	//싱글톤 패턴
	
	private static BookDao single;
	
	private BookDao() {};
	
	public static BookDao getInstance() {
		if(single == null) {
			single = new BookDao();
		}
		return single;
	}

	public ArrayList<BookVo> selectList() {
		ArrayList<BookVo> bookList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from guestbook order by id desc");
			
			while(rs.next()) {
				//실습 : vo로 만들어서 list에 채우세요
				BookVo bvo = new BookVo();
				bvo.setId(rs.getInt("id"));
				bvo.setPassword(rs.getString("password"));
				bvo.setMsg(rs.getString("msg"));
				bvo.setWriter(rs.getString("writer"));
				bvo.setIp(rs.getString("ip"));
				bvo.setWritedate(rs.getString("writedate"));
				
				bookList.add(bvo);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbCloser.close(conn, stmt, rs);
		}
		
		
		return bookList;
	}

	public void add(BookVo bvo) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			String query = String.format("insert into guestbook values(seq_guestbook_id.nextval, "
					+ "'%s', '%s', '%s', '%s', systimestamp(0))", 
					bvo.getPassword(), bvo.getMsg(), bvo.getWriter(), bvo.getIp());
			stmt.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbCloser.close(conn, stmt, null);
		}
	}
	
	
	
}