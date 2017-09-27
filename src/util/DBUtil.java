package util;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtil {
	private static Connection conn;

	public static Connection getConnection() {
		Logger logger = Logger.getLogger(DBUtil.class.getName());
		logger.log(Level.INFO,"No open connection");
		if (conn != null)
			return conn;
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		String url = "jdbc:mysql://aa16lmxbq1txb0j.coi6zcmnhpte.us-east-2.rds.amazonaws.com:3306/db";
		String username = "tsofendbmaster2";
		String password = "ESEahn57327";

		// DEBUG VALUES
		// String url = "jdbc:mysql://localhost:3306/db";
		// String username = "root";
		// String password = "";
		try {
			logger.log(Level.INFO,"Attempting to connection to: " + url + " with user: " + username + " password: " +password);
			conn = DriverManager.getConnection(url, username, password);
		}

		catch (java.sql.SQLException e) {
			logger.log(Level.SEVERE,"Connection not opened");
			System.out.println(e.getMessage());
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
