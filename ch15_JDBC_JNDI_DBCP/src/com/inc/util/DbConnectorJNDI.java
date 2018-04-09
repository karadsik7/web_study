package com.inc.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DbConnectorJNDI {
	
	public static Connection getConnection() {
		DataSource ds = null;
		
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracle_xe");
			//BasicDataSourceFactory bdf = new BasicDataSourceFactory();
			//ds = bdf.createDataSource("hr/1111"); 
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
