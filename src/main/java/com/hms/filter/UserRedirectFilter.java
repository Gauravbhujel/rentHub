package com.hms.filter;

import com.hms.models.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/pages/login.jsp", "/pages/signup.jsp"})
public class UserRedirectFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;

        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        if (user != null) {
            httpResp.sendRedirect(httpReq.getContextPath() + "/home");
            return;
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
