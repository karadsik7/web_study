package com.inc.dao;

import java.util.List;
import java.util.Map;

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
	
	public List<Board> selectList(Map<String, Object> searchMap){
		SqlSession session = factory.openSession();
		List<Board> boardList = session.selectList("board.selectList", searchMap);
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


	public void plusHit(int id) {
		SqlSession session = factory.openSession(true);
		session.update("board.plusHit", id);
		session.close();
	}

	public void delete(int id) {
		SqlSession session = factory.openSession(true);
		session.delete("board.delete", id);
		session.close();
	}
	
	public void modify(Board board) {
		SqlSession session = factory.openSession(true);
		session.update("board.modify", board);
		session.close();
	}
	
	public int totalCount() {
		SqlSession session = factory.openSession();
		int count = session.selectOne("board.totalCount"); 
		session.close();
		return count;
	}
}
