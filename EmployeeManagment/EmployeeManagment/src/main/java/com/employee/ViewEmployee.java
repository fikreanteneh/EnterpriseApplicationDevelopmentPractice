package com.employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


@WebServlet("/ViewEmployee")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewEmployee() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM employee";
		Connection connection = DBManager.getConnection();
		PrintWriter out = response.getWriter();
        try {
        	Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            response.setContentType("text/html");
            out.println("<html><body>");
            out.println("<h2>List of Employees</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Designation</th><th>Salary</th></tr>");

            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getInt("id") + "</td>");
                out.println("<td>" + resultSet.getString("name") + "</td>");
                out.println("<td>" + resultSet.getString("designation") + "</td>");
                out.println("<td>" + resultSet.getDouble("salary") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body></html>");
            
                         
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
