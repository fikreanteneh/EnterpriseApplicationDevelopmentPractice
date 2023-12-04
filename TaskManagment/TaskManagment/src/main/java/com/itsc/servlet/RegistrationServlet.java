package com.itsc.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itsc.config.DBManager;
import com.itsc.model.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.print(false);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.print(name + email + password);
	
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		String query = "INSERT INTO users (name, email, password) VALUES ('" + name + "', '" + email + "', " + password + ")";
		Connection connection = DBManager.getConnection();
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(query);
        	preparedStatement.execute(); 
			response.sendRedirect("confirmation.jsp");

		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect("error.jsp");

		}
	}
}