package com.inc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.inc.util.DbCloser;
import com.inc.util.DbConnector;
import com.inc.vo.MemberVo;

public class MemberDao {

	private static MemberDao single;
	
	private MemberDao() {}
	
	public static MemberDao getInstance() {
		if(single == null) {
			single = new MemberDao();
		}
		return single;
	}
	
	public String dualCheck(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(String.format("select id from member where id = '%s'", id));
			if(rs.next()) {
				result = rs.getString("id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCloser.close(conn, stmt, rs);
		}
		return result;
	}

	public void insert(MemberVo mvo) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(String.format("insert into member values('%s', '%s', '%s', '%s')", 
					mvo.getId(), mvo.getPassword(), mvo.getName(), mvo.getGender()));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCloser.close(conn, stmt, null);
		}
	}

	public MemberVo login(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		MemberVo mvo = null;
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(String.format("select * from member where id = '%s'", id));
			if(rs.next()) {
				mvo = new MemberVo();
				mvo.setId(rs.getString("id"));
				mvo.setPassword(rs.getString("password"));
				mvo.setName(rs.getString("name"));
				mvo.setGender(rs.getString("gender"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCloser.close(conn, stmt, rs);
		}
		return mvo;
	}
	
}
