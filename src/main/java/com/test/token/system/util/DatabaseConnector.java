package com.test.token.system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DatabaseConnector {


	
	
	public static Connection getConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/token_system", "root", "root");
			
			return connection;
			
		} catch (Exception e) {
			System.out.println("Exception in getConnection: "+e);
		}
	
		return null;
	}

	public static ResultSet execQuery(String sql) {

		try {
			
			return getConnection().createStatement().executeQuery(sql);

		} catch (Exception e) {
			System.out.println("Exception in execQuery: "+e);
		}
		return null;

	}

	public static void execUpdateQuery(String sql) {
		
		try {
			
			getConnection().createStatement().executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("Exception in execUpdateQuery: "+e);
		}
		
		
	}

}
