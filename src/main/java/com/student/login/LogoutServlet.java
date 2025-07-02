package com.student.login;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); // don’t create new session
        if (session != null) {
            session.invalidate(); // clear session data
        }

        // Redirect back to login page
        response.sendRedirect("login.html");
    }
}
