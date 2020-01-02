package com.DanskeIt.Example;

import java.sql.*;

public class DBUtils {
	private static final String USER = "root";
	private static final String PASSWORD = "rootdb";
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String DRIVER_CLASSNAME = "com.mysql.cj.jdbc.Driver";  // can be googled out
															
	public static Connection getConnection() {
		Connection connection = null;
		// Load the driver
		try {
			Class.forName(DRIVER_CLASSNAME); //load and register driver
			
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
 
	public static void closeConnection(Connection connection)
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
