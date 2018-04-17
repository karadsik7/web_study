package com.inc.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DbConnector {
	//singleton 디자인 패턴의 목적 : 객체를 단 하나만 생성해야하는 경우
	//원리 : 생성자를 private로 잠가 다른 클래스에서 객체생성을 불가능하도록 막은 후에
	//객체를 받아와야하기 때문에 getInstance라는 메서드와 자기 자신을 single로 클래스속성으로 만든다
	//getInstance 메서드 내부에서 자기 자신이 널일 경우에 single에 자신의 객체를 생성하고 리턴한다
	//이후엔 널값이 아니기때문에 객체생성이 안된다.
	private DataSource ds = null;
	
	private static DbConnector single;
	
	private DbConnector() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracle_xe");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static DbConnector getInstance() {
		if(single == null) {
			single = new DbConnector();
		}
		return single;
	}
	
	public Connection getConnection() {

		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
