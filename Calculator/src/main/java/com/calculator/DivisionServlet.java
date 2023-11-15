package com.calculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Division")
public class DivisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DivisionServlet() {
        // TODO Auto-generated constructor stub
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double num1 = Integer.parseInt(request.getParameter("num1"));
		double num2 = Integer.parseInt(request.getParameter("num2"));
		double result = num1 / num2;
		PrintWriter out = response.getWriter();
		 response.setContentType("text/html");
         out.println("<html><body>");
         out.println("<script>");
         out.println("alert('Result is " + result + " ')");
         out.println("history.go(-1);");
         out.println("</script>");
         out.println("</body></html>");
         out.close();
		
		
	}
}
