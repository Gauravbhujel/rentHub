package com.hms.filter;

import com.hms.models.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/pages/admin.jsp", "/admin"})
public class UserFiler implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        if (user == null) {
            // User not logged in
            response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
            return;
        }

        if (!user.isAdmin()) {
            // User logged in but not admin
            response.sendRedirect(request.getContextPath() + "/pages/profile.jsp"); // Or show 403 page
            return;
        }

        // User is admin, allow access
        filterChain.doFilter(servletRequest, servletResponse);
    }


}