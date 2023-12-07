//package com.itsc.filter;
//import java.io.IOException;
//import com.itsc.model.User;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebFilter("/*")
//public class AuthorizationFilter implements Filter {
//
//    public void init() throws ServletException {
// 
//    }
//    public void destroy() {
//
//    }
//
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
//			throws IOException, ServletException {
//		HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        Object user = request.getAttribute("User");
//        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
//
//        if (user != null && !(path.startsWith("/TaskManagment/Task/") || "/TaskManagment/Logout".equals(path))) {
//        	httpResponse.sendRedirect("/TaskManagment/Task");
//        } else if (user == null && !(path.startsWith("/TaskManagment/Login") || "/TaskManagment/Register".equals(path)) ) {
//        	httpResponse.sendRedirect("/TaskManagment/Login");
//        }else {
//            filter.doFilter(request, response);
//        }
//    }
//	
//	}
//
// 
//
