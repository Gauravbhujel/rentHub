package com.hms.controller;

import com.hms.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

public class UserDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        // Simulated list of users, ideally fetch all from DB
        ArrayList<User> users = new ArrayList<>();
        // Populate users list from DB
        request.setAttribute("users", users);
        request.getRequestDispatcher("user_dashboard.jsp").forward(request, response);
    }
}
