package com.inc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.inc.util.MyBatisConnector;
import com.inc.vo.DeptVo;

public class DeptDao {

	private static DeptDao single;
	private SqlSessionFactory factory;
	
	private DeptDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	};

	public static DeptDao getInstance() {
		if (single == null) {
			single = new DeptDao();
		}
		return single;
	}
	
	public List<DeptVo> selectList(){
		SqlSession sqlSession = factory.openSession();
		List<DeptVo> deptList = sqlSession.selectList("department.selectList");
		sqlSession.close();
		return deptList;
	}
	
}
