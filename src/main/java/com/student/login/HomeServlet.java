package com.student.login;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession(false); // don’t create new session
        String username = (session != null) ? (String) session.getAttribute("user") : null;

        if (username != null) {
            response.getWriter().println("<h2>Welcome to the Student Portal, " + username + "!</h2>");
            response.getWriter().println("<p><a href=\"logout\">Logout</a></p>");
        } else {
            response.getWriter().println("<p>You must <a href=\"login.html\">log in</a> first.</p>");
        }
    }
}
