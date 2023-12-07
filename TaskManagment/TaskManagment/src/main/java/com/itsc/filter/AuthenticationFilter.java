package com.itsc.filter;
import java.io.IOException;
import com.itsc.model.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    public void init() throws ServletException {
 
    }
    public void destroy() {

    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
			System.out.println("Authentication Filterrrrrrrrrrrrrrrrrrrrrrrrr");
		 	HttpServletRequest httpRequest = (HttpServletRequest) request;
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        jakarta.servlet.http.Cookie[] cookies = httpRequest.getCookies();
	        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
	        User user = null;
	        try {
	        	if(cookies.length > 0   && "email".equals(cookies[0].getName())){
	        		user = User.getUserByEmail(cookies[0].getValue());
		        }
	        }
	        catch (Exception ex) {
//                httpResponse.sendRedirect("/TaskManagment/Login");
//	        	request.getRequestDispatcher("/Login").forward(request, response);	
	        }
	        System.out.println("-----------" + user + path);
	        if (user != null && !(path.startsWith("/Task/") || "/Logout".equals(path))) {
	        	httpResponse.sendRedirect("/TaskManagment/Task");
	        } else if (user == null && !(path.startsWith("/Login") || path.startsWith("/Registration")) ) {
	        	httpResponse.sendRedirect("/TaskManagment/Login");
	        }else {
	        	request.setAttribute("User", user);
	        	filter.doFilter(httpRequest, httpResponse);
	        }
	        		
	}
}
