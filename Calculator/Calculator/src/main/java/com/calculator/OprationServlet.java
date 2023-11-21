package com.calculator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;




@WebServlet("/Operation")
public class OprationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OprationServlet() {
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		switch(operation) {
			case "addition":
				RequestDispatcher ard = request.getRequestDispatcher("Addition");
				ard.forward(request, response);
				break;
			case "multiplication":
				RequestDispatcher mrd = request.getRequestDispatcher("Multiplication");
				mrd.forward(request, response);
				break;
			case "division":
				RequestDispatcher drd = request.getRequestDispatcher("Division");
				drd.forward(request, response);
				break;
			case "substarction":
				RequestDispatcher srd = request.getRequestDispatcher("Substraction");
				srd.forward(request, response);
				break;
			
		}
		
		
	}

}
