package util;

import java.sql.*;

public class DBUtil {
	 private static Connection conn;
	 
	    public static Connection getConnection() {
	        if( conn != null )
	            return conn;
	    		try {
	    			Class.forName("com.mysql.jdbc.Driver");
	    			
	    		} catch (ClassNotFoundException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    			

	    		}

	         String url = "jdbc:mysql://tsofeninstance100.coi6zcmnhpte.us-east-2.rds.amazonaws.com/db";	         
	         String username = "tsofenmasterdb";
	    	 String password = "ESEahn57327";
	    	 
	    	 try 
	         {
	             
	             conn = DriverManager.getConnection(url, username, password);
	         }
	           
	    	 catch ( java.sql.SQLException e) 
	         {
	 	            System.out.println(e.getMessage());
	 	     }
	 
	        return conn;
	    }
	 
	    public static void closeConnection( Connection toBeClosed ) {
	        if( toBeClosed == null )
	            return;
	        
	        
	        try {
	            toBeClosed.close();
	        } catch (SQLException e) {
	        	System.out.println(e.getMessage());
	        }
	    }
}
