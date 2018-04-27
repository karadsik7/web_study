package com.inc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.inc.util.MyBatisConnector;
import com.inc.vo.Board;

public class BoardDao {
	
	private static BoardDao single;
	private SqlSessionFactory factory;
	
	private BoardDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	
	public static BoardDao getInstance() {
		if(single == null) {
			single = new BoardDao();
		}
		return single;
	}
	
	public List<Board> selectList(){
		SqlSession session = factory.openSession();
		List<Board> boardList = session.selectList("board.selectList");
		session.close();
		return boardList;
	}


	public Board selectOne(int id) {
		SqlSession session = factory.openSession();
		Board board = session.selectOne("board.selectOne",id);
		session.close();
		return board;
	}


	public void add(Board board) {
		SqlSession session = factory.openSession(true);
		session.insert("board.insert", board);
		session.close();
	}
	
}
