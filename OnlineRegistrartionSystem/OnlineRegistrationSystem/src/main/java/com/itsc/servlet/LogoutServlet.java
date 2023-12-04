package com.itsc.servlet;


import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("welcome.jsp");
		
	}
}