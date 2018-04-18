package com.inc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.inc.util.DbCloser;
import com.inc.util.DbConnector;
import com.inc.vo.PhotoVo;

public class PhotoDao {

	private static PhotoDao single;
	
	private PhotoDao() {};
	
	public static PhotoDao getInstance() {
		if(single == null) {
			single = new PhotoDao();
		}
		return single;
	}
	
	public ArrayList<PhotoVo> selectList(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<PhotoVo> photoList = new ArrayList<>();
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			String query = "select * from photo order by id desc";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String filename = rs.getString("filename");
				String password = rs.getString("password");
				String regdate = rs.getString("regdate").substring(0, 10);
				
				PhotoVo pvo = new PhotoVo(id, title, filename, password, regdate);
				photoList.add(pvo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbCloser.close(conn, stmt, rs);
		}
		
		return photoList;
		
	}

	public void insert(PhotoVo pvo) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			String query = String.format("insert into photo values(seq_photo_id.nextval, '%s',"
					+ "'%s', '%s', sysdate)", pvo.getTitle(), pvo.getFilename(), pvo.getPassword());
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbCloser.close(conn, stmt, null);
		}
	}
	
	public String getPassword(int id) {
		String password = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(String.format("select password from photo where id = %d", id));
			rs.next();
			password = rs.getString("password");
		} catch (SQLException e) { 
			e.printStackTrace();
		}finally {
			DbCloser.close(conn, stmt, rs);
		}
		return password;
	}

	public void delete(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(String.format("delete from photo where id = %d", id));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbCloser.close(conn, stmt, rs);
		}
		
	}
	
}
