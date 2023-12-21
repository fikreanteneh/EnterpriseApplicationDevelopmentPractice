package com.itsc.filter;
import java.io.IOException;

import com.itsc.config.URLConfig;
import com.itsc.model.User;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/Login", "/Register" })
public class UnauthorizationFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }
    public void destroy() {
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        Object user = request.getAttribute("User");
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        if (user != null){
            httpResponse.sendRedirect(String.format("/%s/Task", URLConfig.rootUrl));
        }else {
            filter.doFilter(request, response);
        }
    }

}



