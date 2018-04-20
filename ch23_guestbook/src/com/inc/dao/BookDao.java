package com.inc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.inc.util.DbCloser;
import com.inc.util.DbConnector;
import com.inc.util.MyBatisConnector;
import com.inc.vo.BookVo;

public class BookDao {
	
	private static BookDao single;
	private SqlSessionFactory factory;
	private BookDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	};
	
	public static BookDao getInstance() {
		if(single == null) {
			single = new BookDao();
		}
		return single;
	}

	public List<BookVo> selectList() {
		SqlSession session = factory.openSession();
		List<BookVo> bookList = session.selectList("guestbook.selectList");
		session.close();
		return bookList;
	}

	public void add(BookVo bvo) {
		//오픈세션의 파라미터엔 오토커밋 여부가 들어감
		//SqlSession session = factory.openSession(true);
		
		//수동커밋
		SqlSession session = factory.openSession();
		session.insert("guestbook.add", bvo);
		session.commit();
		session.close();
	}
	
	public void del(int id) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(String.format("delete from guestbook where id = %d", id));
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbCloser.close(conn, stmt, null);
		}
	}
	
	public BookVo selectOne(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		BookVo bvo = new BookVo();
		
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			String query = String.format("select * from guestbook where id = %d", id);
			rs = stmt.executeQuery(query);
			rs.next();
			
			bvo.setId(rs.getInt("id"));
			bvo.setPassword(rs.getString("password"));
			bvo.setMsg(rs.getString("msg"));
			bvo.setWriter(rs.getString("writer"));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbCloser.close(conn, stmt, rs);
		}
		return bvo;		
	}
	
	public void modify(BookVo bvo) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			int id = bvo.getId();
			String writer = bvo.getWriter();
			String password = bvo.getPassword();
			String msg = bvo.getMsg();
			
			stmt.executeUpdate(String.format("update guestbook set writer = '%s', password = '%s', msg = '%s' where id = %d", writer, password, msg, id));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbCloser.close(conn, stmt, null);
		}
	}
	
	public String getPassword(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String password = null;
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(String.format("select password from guestbook where id = %d", id));
			rs.next();
			password = rs.getString("password");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbCloser.close(conn, stmt, rs);
		}
		return password;
	}
	
	public int getWriterCheck(String writer) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int result = 404404;
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			String query = String.format("select count(*) as result from guestbook where writer = '%s'", writer);
			rs = stmt.executeQuery(query);
			rs.next();
			result = rs.getInt("result");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbCloser.close(conn, stmt, rs);
		}
		return result;
	}
	
}
