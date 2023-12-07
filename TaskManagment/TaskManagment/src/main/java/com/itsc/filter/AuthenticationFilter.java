package com.itsc.filter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itsc.config.DBManager;
import com.itsc.model.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public abstract class AuthenticationFilter implements Filter {

    public void init() throws ServletException {
 
    }
    public void destroy() {

    }


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		 	HttpServletRequest httpRequest = (HttpServletRequest) request;
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        jakarta.servlet.http.Cookie[] cookies = httpRequest.getCookies();
	
	        try {
	        	if(cookies.length == 0 ||  !"email".equals(cookies[0].getName())){
	        		throw new Exception("Unauthenticated User");
		        }
	        	request.setAttribute("User", User.getUserByEmail(cookies[0].getValue()));
	        	filter.doFilter(httpRequest, httpResponse);	
	        }
	        catch (Exception ex) {
//                httpResponse.sendRedirect(httpRequest.getContextPath() + "/Login");
	        	request.getRequestDispatcher("/Login").forward(request, response);	
	        }
	        
		
	}

 
   
}
