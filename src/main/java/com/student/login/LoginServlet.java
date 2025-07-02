package com.student.login;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve login parameters
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        out.println("<h1>Hello, " + username + "!</h1>");
        // Validate credentials
        if (UserStore.validateUser(username, password)) {
            // On success: create session and welcome
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("home");
            // response.getWriter().println("Welcome, " + username + "!");
            // response.getWriter().println("<p><a href=\"logout.html\">Logout</a></p>");
        } else {
            response.getWriter().println("Invalid username or password.");
            response.getWriter().println("<p><a href=\"login.html\">Try again</a></p>");
        }
    }
}
