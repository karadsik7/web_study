package com.inc.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.inc.util.MyBatisConnector;
import com.inc.vo.EmpVo;

public class EmpDao {
	
	private static EmpDao single;
	//1-2. sqlSessionFactory 생성
	private SqlSessionFactory factory;
	
	private EmpDao() {
		//1-3. 싱글턴 패턴의 커넥터로 팩토리를 하나 받아와서 초기화함
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	};

	public static EmpDao getInstance() {
		if (single == null) {
			single = new EmpDao();
		}
		return single;
	}
	
	public List<EmpVo> selectList(){
		List<EmpVo> empList = new ArrayList<>();
		//마이바티스 사용
		//1. 처리 객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		//2. 쿼리 날리기
		//""문법 : namespace.tagid
		//(namespace:테이블명, 뒤에는 해당 테이블명의 맵핑xml에서 설정한 select태그의 id값)
		//그 내부의 내부의 쿼리문 실행
		empList = sqlSession.selectList("employee.selectList");
		//3. 세션 닫기
		sqlSession.close();
		//4. 리턴
		return empList;
	}

	
}
