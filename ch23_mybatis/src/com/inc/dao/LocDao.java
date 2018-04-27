package com.inc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.inc.util.MyBatisConnector;
import com.inc.vo.LocVo;

public class LocDao {

	private static LocDao single;
	private SqlSessionFactory factory;
	private LocDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	};

	public static LocDao getInstance() {
		if (single == null) {
			single = new LocDao();
		}
		return single;
	}

	public List<LocVo> selectList() {
		SqlSession session = factory.openSession();
		List<LocVo> locList = session.selectList("locations.selectList");
		session.close();
		return locList;
	}
	
	
}
