package database;

import java.sql.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ConnectionPool {
	private static ConnectionPool pool = null;
	private static DataSource dataSource = null;
	
	private ConnectionPool() {
		try {
			InitialContext ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/laptop_website");
		} catch (NamingException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public static synchronized ConnectionPool getInstance() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}
	
	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
	
	public void freeConnection(Connection c) {
		try {
			c.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
}
