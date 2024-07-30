package com.tek.OFOS.generic.Databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Databaseutility {
	Connection conn;
	public void getconnection(String url,String username,String password) throws Exception
	{
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 conn = DriverManager.getConnection(url, username, password);
		}catch (Exception e) {
			System.out.println("handled");
		}
		
	}
	public void closeconnection()
	{
		try {
			conn.close();
		}catch (Exception e) {
			
		}
	}
	public ResultSet executeselectQuery(String query) throws Exception
	{ ResultSet result = null;
		try {
		Statement state = conn.createStatement();
         result = state.executeQuery(query);
	}catch (Exception e) {
		
	}
	return result;
	}
	public int executenonselectquery(String query) throws SQLException
	{   int result=0;
	try {
		Statement state = conn.createStatement();
		result=state.executeUpdate(query);
	}catch (Exception e) {
		
	}
	return result;
	}
}
