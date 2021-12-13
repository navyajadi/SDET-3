package com.JDBC.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQueryTest {

	@Test

	public void executeQueryTest() throws SQLException {

		// step-1 Register the driver
		Connection connet = null;
		try {
			Driver driver = new Driver();

			DriverManager.registerDriver(driver);
			
			// step-2 connect to the database

			connet = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");

			// step-3 create a statement
			Statement stmt = connet.createStatement();

			// ExcuteQuery
			ResultSet results = stmt.executeQuery("select* from students_info");
			while(results.next()) {

			System.out.println(results.getString(1)+" "+results.getString(2));
		} 
		}
			catch (SQLException e) {

			e.printStackTrace();
		}

		// Close the Connection
		finally {
			connet.close();
		}
	}

}
