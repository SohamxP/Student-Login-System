package com.student.login;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters (name, email, username, password)
        String fullName = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");

        // Basic validation: ensure non-null and not empty (could be expanded)
        if (fullName == null || email == null || username == null || password == null ||
                fullName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            response.getWriter().println("All fields are required.");
            return;
        }

        // Check if user already exists
        if (UserStore.userExists(username)) {
            response.getWriter().println("Username already exists. Please choose another.");
        } else {
            // Hash password and save new user
            String hashedPassword = PasswordUtil.hashPassword(password);
            User newUser = new User(fullName, email, username, hashedPassword);
            if (UserStore.addUser(newUser)) {
                response.getWriter().println(
                        "<p>Registration successful!</p>" +
                                "<p><a href=\"login.html\">Click here to login</a></p>");
            } else {
                response.getWriter().println("Error saving user. Please try again.");
            }
        }
    }
}
