package com.itsc.filter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.itsc.config.URLConfig;
import com.itsc.model.User;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }
    public void destroy() {

    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		 	HttpServletRequest httpRequest = (HttpServletRequest) request;
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
//	        HttpSession session =httpRequest.getSession();
//	        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
			Cookie[] cookies = ((HttpServletRequest) request).getCookies();
			Map<String, String> hashMap = new HashMap<>();
			for (Cookie cookie: cookies) {
				hashMap.put(cookie.getName(), cookie.getValue());
			}
	        User user = null;
	        try {
				user = User.getUserByEmail((hashMap.get("email")));
				request.setAttribute("User", user);
	        }
	        catch (Exception ex) {
	        }
		filter.doFilter(httpRequest, httpResponse);

	}
}
