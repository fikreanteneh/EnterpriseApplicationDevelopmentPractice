package com.employee;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ZStart")
public class ZStart extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		PrintWriter pw = res.getWriter();
		pw.println("Hello World");
	}
}