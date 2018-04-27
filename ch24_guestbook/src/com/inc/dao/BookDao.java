package com.inc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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

	public List<BookVo> selectList(Map<String, String> searchMap) {
		SqlSession session = factory.openSession();
		List<BookVo> bookList = session.selectList("guestbook.selectList", searchMap);
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
		SqlSession session = factory.openSession(true);
		session.delete("guestbook.del", id);
		session.close();
	}
	
	public BookVo selectOne(int id) {
		SqlSession session = factory.openSession();
		BookVo bvo = session.selectOne("guestbook.selectOne", id);
		session.close();
		return bvo;
	}
	
	public void modify(BookVo bvo) {
		SqlSession session = factory.openSession(true);
		session.update("guestbook.modify", bvo);
		session.close();
	}
	
	public String getPassword(int id) {
		SqlSession session = factory.openSession();
		String password = session.selectOne("guestbook.getPassword", id);
		session.close();
		return password;
	}
	
	public int getWriterCheck(String writer) {
		SqlSession session = factory.openSession();
		int result = 404404;
		result = session.selectOne("guestbook.getWriterCheck", writer);
		session.close();
		return result;
	}
	
}
