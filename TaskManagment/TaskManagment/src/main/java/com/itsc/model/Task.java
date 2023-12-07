package com.itsc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itsc.config.DBManager;

import jakarta.servlet.ServletException;

public class Task {
	public int id;
	public int userid;
	public String title;
	public String description;
	public String priority;
	public Task(int userid, String title, String description, String priority) {
		this.userid = userid;
		this.title = title;
		this.description = description;
		this.priority = priority;
	};
	public Task(int id, int userid, String title, String description, String priority) {
		this.id = id;
		this.userid = userid;
		this.title = title;
		this.description = description;
		this.priority = priority;
	};
	
	
	
	public static List<Task> getTasksByUser(int userid) throws Exception {
        Connection connection = DBManager.getConnection();
        String query = "SELECT * FROM tasks WHERE userid = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, userid);
        ResultSet rs = pstmt.executeQuery();
        List<Task> tasks = new ArrayList<Task>();
        while (rs.next()) {
            int taskId = rs.getInt("id");
            String title = rs.getString("title");
            String description = rs.getString("description");
            String priority = rs.getString("priority");
            tasks.add(new Task(taskId, userid, title, description, priority));
        }
        return tasks;
    	
	}
	
	public static void addTask(int userid, String title, String description, String priority) throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "INSERT INTO tasks (userid, title, description, priority) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, userid);
        pstmt.setString(2, title);
        pstmt.setString(3, description);
        pstmt.setString(4, priority);
        pstmt.executeUpdate();
    }

    public static void deleteTask(int taskId) throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "DELETE FROM tasks WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, taskId);
        pstmt.executeUpdate();
    }

    public static void updateTask(int taskId, String title, String description, String priority) throws SQLException {
        Connection connection = DBManager.getConnection();
        String query = "UPDATE tasks SET title = ?, description = ?, priority = ? WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, title);
        pstmt.setString(2, description);
        pstmt.setString(3, priority);
        pstmt.setInt(4, taskId);
        pstmt.executeUpdate();
    }
	

}
