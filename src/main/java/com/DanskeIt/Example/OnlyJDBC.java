package com.DanskeIt.Example;

import java.sql.*;

public class OnlyJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee employee = new Employee("A0007","Sathyanarayana","G S",1000);
		
		System.out.println(addEmployee(employee));
		

	}
	
	public static String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String insertStatement = "insert into Employee(employeeId,empFirstName, empLastName,empSalary)"
				+ " values(?,?,?,?)"; // Prepared statement
		
		PreparedStatement preparedStatement = null;

		Connection connection = null;

		connection = DBUtils.getConnection();

		if (connection == null) {
			return "failed";
		} else {
			try {
				preparedStatement = connection.prepareStatement(insertStatement);
				preparedStatement.setString(1, employee.getEmployeeId());
				preparedStatement.setString(2, employee.getEmpFirstName());
				preparedStatement.setString(3, employee.getEmpLastName());
				preparedStatement.setFloat(4, employee.getEmpSalary());

				int result = preparedStatement.executeUpdate();

				if (result > 0)
					return "success";
				else
					return "fail";

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtils.closeConnection(connection);
			}
			return "fail";
		}
	}
}

