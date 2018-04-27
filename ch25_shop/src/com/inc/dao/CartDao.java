package com.inc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.inc.util.MyBatisConnector;
import com.inc.vo.CartVo;

public class CartDao {

	private static CartDao single;
	private SqlSessionFactory factory;
	private CartDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	};

	public static CartDao getInstance() {
		if (single == null) {
			single = new CartDao();
		}
		return single;
	}
	
	public List<CartVo> cartList(String u_id){
		SqlSession session = factory.openSession();
		List<CartVo> cartList = session.selectList("cart.selectList", u_id);
		session.close();
		return cartList;
	}

	public int getCount(Map<String, Object> idMap) {
		SqlSession session = factory.openSession();
		int count = session.selectOne("cart.getCount", idMap);
		session.close();
		return count;
	}
	
	public void insert(Map<String, Object> idMap) {
		SqlSession session = factory.openSession(true);
		session.insert("cart.insert", idMap);
		session.close();
	}

	public void modify(CartVo cvo) {
		SqlSession session = factory.openSession(true);
		session.update("cart.modify", cvo);
		session.close();
	}

	public void delete(int id) {
		SqlSession session = factory.openSession(true);
		session.delete("cart.delete", id);
		session.close();
	}
	
}
