package com.inc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.inc.util.DbCloser;
import com.inc.util.DbConnector;
import com.inc.vo.ScoreVo;

public class ScoreDao {
	
	private static ScoreDao single;
	
	private ScoreDao() {}
	
	public static ScoreDao getInstance() {
		if(single == null) {
			single = new ScoreDao();
		}
		return single;
	}
	
	
	
	public ArrayList<ScoreVo> selectList(){
		ArrayList<ScoreVo> scoreList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from score_view");
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int math = rs.getInt("math");
				int total = rs.getInt("total");
				double avg = rs.getDouble("avg");
				
				ScoreVo svo = new ScoreVo();
				svo.setId(id);
				svo.setName(name);
				svo.setKor(kor);
				svo.setEng(eng);
				svo.setMath(math);
				svo.setTotal(total);
				svo.setAvg(avg);
				
				scoreList.add(svo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbCloser.close(conn, stmt, rs);
		}
		return scoreList;
	}
	
	public void insert(ScoreVo svo) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			String query = String.format("insert into score values(seq_score_id.nextval, '%s', %d, %d, %d)",
					svo.getName(), svo.getKor(), svo.getEng(), svo.getMath());
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbCloser.close(conn, stmt, null);
		}
	}
	
	public void delete(int id) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			String query = String.format("delete from score where id = %d", id);
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbCloser.close(conn, stmt, null);
		}
	}
	
	public ScoreVo selectOne(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ScoreVo svo = new ScoreVo();
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			String query = String.format("select * from score where id = %d", id);
			rs = stmt.executeQuery(query);
			rs.next();
			
			svo.setId(rs.getInt("id"));
			svo.setName(rs.getString("name"));
			svo.setKor(rs.getInt("kor"));
			svo.setEng(rs.getInt("eng"));
			svo.setMath(rs.getInt("math"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbCloser.close(conn, stmt, rs);
		}
		return svo;
	}
	
	public void modify(ScoreVo svo) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DbConnector.getInstance().getConnection();
			stmt = conn.createStatement();
			String query = String.format("update score set name = '%s', kor = %d, "
					+ "eng = %d, math = %d where id = %d", 
					svo.getName(), svo.getKor(), svo.getEng(), svo.getMath(), svo.getId());
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbCloser.close(conn, stmt, null);
		}
		
	}
	
}
