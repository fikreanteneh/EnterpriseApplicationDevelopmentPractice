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

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email + password);
        try {
        	User user = User.getUserByEmailAndPassword(email, password);
        	System.out.println(user);
        	request.setAttribute("User", user );
            Cookie cookie = new Cookie("email", user.email);
            cookie.setMaxAge(3600*24*7);
            response.addCookie(cookie);
        	response.sendRedirect("/Task");
		} catch (Exception e) {
			request.setAttribute("Error", e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}