package com.hms.controller;

import com.hms.DAO.PropertyDAO;
import com.hms.models.Property;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

public class ViewAllPropertiesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        ArrayList<Property> list = (ArrayList<Property>) new PropertyDAO().getApprovedProperties("active");
        request.setAttribute("properties", list);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
