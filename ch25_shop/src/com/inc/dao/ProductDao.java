package com.inc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.inc.util.MyBatisConnector;
import com.inc.vo.ProductVo;

public class ProductDao {

	private static ProductDao single;
	private SqlSessionFactory factory;
	
	
	private ProductDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	};

	public static ProductDao getInstance() {
		if (single == null) {
			single = new ProductDao();
		}
		return single;
	}
	
	public List<ProductVo> productList(String category){
		SqlSession session = factory.openSession();
		List<ProductVo> productList = session.selectList("product.productList", category);
		session.close();
		return productList;
	}

	public ProductVo selectOne(int id) {
		SqlSession session = factory.openSession();
		ProductVo pvo = session.selectOne("product.getProductVo", id);
		session.close();
		return pvo;
	}

	public void insert(ProductVo pvo) {
		SqlSession session = factory.openSession(true);
		session.insert("product.insert", pvo);
		session.close();
	}
	
	
	
}
