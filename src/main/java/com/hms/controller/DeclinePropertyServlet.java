package com.hms.controller;

import com.hms.DAO.PropertyDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/decline")
public class DeclinePropertyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int propertyId = Integer.parseInt(request.getParameter("propertyId"));
        PropertyDAO dao = new PropertyDAO();
        dao.deleteProperty(propertyId);
        response.sendRedirect("explore");
    }
}