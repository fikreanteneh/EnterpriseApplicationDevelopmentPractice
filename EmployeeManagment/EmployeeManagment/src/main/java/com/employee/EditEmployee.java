package com.employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



@WebServlet("/EditEmployee/:id")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditEmployee() {
        // TODO Auto-generated constructor stub
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        String eid = pathInfo.substring(1);
        PrintWriter out = response.getWriter();
        try {
        	int id = Integer.parseInt(eid);
        	request.getRequestDispatcher("AddEmployee.html").forward(request, response);
        } catch (NumberFormatException e) {
			e.printStackTrace();
			 response.setContentType("text/html");
            out.println("<html><body>");
            out.println("<script>");
            out.println("alert('Something Went Wrong');");
            out.println("history.go(-1);");
            out.println("</script>");
            out.println("</body></html>");
            out.close();
            }        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String query = "INSERT INTO employee (name, designation, salary) VALUES ('" + name + "', '" + designation + "', " + salary + ")";
		Connection connection = DBManager.getConnection();
		PrintWriter out = response.getWriter();
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.execute();
			 response.setContentType("text/html");
             out.println("<html><body>");
             out.println("<script>");
             out.println("alert('Employee added successfully!');");
             out.println("history.go(-1);");
             out.println("</script>");
             out.println("</body></html>");
             out.close();
             
		} catch (SQLException e) {
			e.printStackTrace();
			 response.setContentType("text/html");
             out.println("<html><body>");
             out.println("<script>");
             out.println("alert('Something Went Wrong');");
             out.println("history.go(-1);");
             out.println("</script>");
             out.println("</body></html>");
             out.close();
		}
	}

}
