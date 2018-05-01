package com.inc.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.inc.util.MyBatisConnector;
import com.inc.vo.Reply;

public class ReplyDao {

	private static ReplyDao single;
	private SqlSessionFactory factory;
	private ReplyDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	};

	public static ReplyDao getInstance() {
		if (single == null) {
			single = new ReplyDao();
		}
		return single;
	}
	
	public void add(Reply reply) {
		SqlSession session = factory.openSession(true);
		session.insert("reply.insert", reply);
		session.close();
	}
	
}
