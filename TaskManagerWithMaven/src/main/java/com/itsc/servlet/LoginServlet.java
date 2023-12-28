package com.itsc.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import com.itsc.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		PrintWriter out = response.getWriter();
		out.println("Yes");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
        try {
        	User user = User.getUserByEmailAndPassword(email, password);
			Cookie cookie = new Cookie("email", user.email);
			cookie.setPath("/");
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
			request.getRequestDispatcher("/Task").forward(request, response    );
//        	response.sendRedirect(String.format("/%s/Task"));
		} catch (Exception e) {
			request.setAttribute("Error", e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}