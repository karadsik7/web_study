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
		
	}
	
}
