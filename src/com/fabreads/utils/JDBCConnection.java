package com.fabreads.utils;
 
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 
/*
 * @author - Prajna
 */
public class JDBCConnection {
 
  public static Connection  getConnection(){
 
	System.out.println("-------- MySQL JDBC Connection Testing ------------");
 
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("MySQL JDBC Driver not found");
		e.printStackTrace();
	}
 
	System.out.println("MySQL JDBC Driver Registered!");
	Connection connection = null;
 
	try {
		connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/fabreads_db","root", "root");
 
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
	}
 
	if (connection != null) {
		System.out.println("Connection Successful!");
	} else {
		System.out.println("Failed to make connection!");
	}
	
	return connection;
  }
  
}
