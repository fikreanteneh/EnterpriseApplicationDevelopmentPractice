package com.itsc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itsc.config.DBManager;

import jakarta.servlet.ServletException;

public class User {
	public int id;
	public String name;
	public String email;
	public String password = "";
	public User(String name, String email) {
		this.email = email;
		this.name = name;
	};
	
	public User(int id, String name, String email) {
		this.email = email;
		this.name = name;
	};
	
	
	
	public static User getUserByEmail(String email) throws Exception {
		Connection connection = DBManager.getConnection();
    	String query = "select * from users where email = ?";
    	PreparedStatement pstmt = connection.prepareStatement(query);
    	pstmt.setString(1, email);
    	ResultSet rs = pstmt.executeQuery();
    	if(rs.next()) {
    		return new User ( Integer.parseInt(rs.getString("id")), rs.getString("email"), rs.getString("name"));
    	}
    	throw new ServletException("User not found");
	}
	
	public static User getUserByEmailAndPassword(String email, String password) throws Exception {
		Connection connection = DBManager.getConnection();
    	String query = "select * from users where email = ? AND password = ?";
    	PreparedStatement pstmt = connection.prepareStatement(query);
    	pstmt.setString(1, email);
    	pstmt.setString(2, password);
    	ResultSet rs = pstmt.executeQuery();
    	if(rs.next()) {
    		return new User ( Integer.parseInt(rs.getString("id")), rs.getString("email"), rs.getString("name"));
    	}
    	throw new ServletException("User not found");
	}
	
	public static void Register(String name, String email, String password) throws Exception {
		Connection connection = DBManager.getConnection();
		String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
    	PreparedStatement pstmt = connection.prepareStatement(query);
    	pstmt.setString(1, name);
    	pstmt.setString(2, email);
    	pstmt.setString(3, password);
    	pstmt.executeUpdate();

	}
	

}
