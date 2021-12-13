package com.JDBC.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateTest {

	@Test

	public void executeUpdate() throws SQLException {
		// step-1 Register the driver
		Connection connet = null;

		try {
			Driver driver = new Driver();

			DriverManager.registerDriver(driver);

			// step-2 connect to the database

			connet = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");

			// step-3 create a statement
			Statement stmt = connet.createStatement();

			int results = stmt.executeUpdate(
					"insert into students_info(regno, firstname, middlename, lastname) values('6', 'navy', 'k', 'j')");

			if (results == 1) {
				System.out.println("Execute update passed");

			} else {
				System.out.println("Execute update fail");

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			connet.close();
		}
}
}
