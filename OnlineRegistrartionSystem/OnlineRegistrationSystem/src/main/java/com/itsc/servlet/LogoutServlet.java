package com.itsc.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itsc.config.DBManager;
import com.itsc.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		Connection connection = DBManager.getConnection();
        try {
        	String query = "select * from users where email = ? AND password = ?";
        	PreparedStatement pstmt = connection.prepareStatement(query);
        	pstmt.setString(1, email);
        	pstmt.setString(2, password);
        	ResultSet rs = pstmt.executeQuery();
        	if(rs.next()) {
        		User user = new User();
        		user.setName(rs.getString("name"));
        		user.setEmail(email);
        		HttpSession session = request.getSession();
                session.setAttribute("user", user);
        		response.sendRedirect("welcome.jsp");
        	}else {
        		response.sendRedirect("signin.jsp");
        	}

		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect("error.jsp");
		}
	}
}