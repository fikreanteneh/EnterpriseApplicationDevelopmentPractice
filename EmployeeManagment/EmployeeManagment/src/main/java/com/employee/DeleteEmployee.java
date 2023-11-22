package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteEmployee() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt( request.getParameter("id"));
		String query = "DELETE FROM employee WHERE id = " + id;
		Connection connection = DBManager.getConnection();
		PrintWriter out = response.getWriter();
        try {
        	PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.execute();
            response.setContentType("text/html");
            out.println("<html><body>");
            out.println("<script>");
            out.println("alert('Deleted Successfuly');");
            out.println("window.location.href = '/EmployeeManagment/ViewEmployee';");
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
