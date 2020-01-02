package com.DanskeIt.Example;
import java.sql.*;

public class SimpleJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String USER = "root";
		final String PASSWORD = "rootdb";
		final String URL = "jdbc:mysql://localhost:3306/test";
		final String DRIVER_CLASSNAME = "com.mysql.cj.jdbc.Driver"; 
		final String query = "select * from employee where employeeId = 'A0001'";
		
		Connection connection;
		
		try {
			
			System.out.println("Load and Register driver"); 
			Class.forName(DRIVER_CLASSNAME); //load and register driver
			
			System.out.println("Establish connection");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			
			System.out.println("Create statement");
			Statement statement = connection.createStatement();
			
			System.out.println("Execute Query");
			ResultSet resultset = statement.executeQuery(query);
			
			resultset.next();
			
			System.out.println(resultset.getString("empfirstname"));
			System.out.println(resultset.getString("emplastname"));
			System.out.println(resultset.getFloat("empSalary"));
			
			statement.close();
			
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getSQLState());
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
