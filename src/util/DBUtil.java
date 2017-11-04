package util;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.tomcat.dbcp.dbcp2.*;


public class DBUtil {
	private static Connection conn;

	public static Connection getConnection() {
		Logger logger = Logger.getLogger(DBUtil.class.getName());
		logger.log(Level.INFO,"No open connection");
		
	
			Context initContext;
			try {
				initContext = new InitialContext();
				Context envContext = (Context) initContext.lookup("java:comp/env");
				BasicDataSource ds = (BasicDataSource) envContext.lookup("jdbc/UsersDB");
				try {
					conn = ds.getConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		
			
		return conn;
		

	}

	public static void closeConnection(Connection toBeClosed) {
		if (toBeClosed == null)
			return;

		try {
			toBeClosed.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
