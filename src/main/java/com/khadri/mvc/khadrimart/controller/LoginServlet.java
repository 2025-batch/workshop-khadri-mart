package com.khadri.mvc.khadrimart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        String uname = req.getParameter("uname");
        String pass = req.getParameter("pass");

        if (uname == null) {
            showLoginPage(resp);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("user", uname);

        resp.sendRedirect("index");
    }

    private void showLoginPage(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<title>Khadri Mart - Login</title>");
        out.println("<link rel='stylesheet' href='logincss.css'>");
        out.println("</head><body>");

        out.println("<header class='navbar'><h1>Khadri Mart</h1></header>");

        out.println("<div class='login-wrapper'>");
        out.println("<div class='login-box'>");
        out.println("<h2>Login</h2>");

        out.println("<form action='login'>");
        out.println("<label>Username</label>");
        out.println("<input type='text' name='uname' placeholder='Enter username' required>");

        out.println("<label>Password</label>");
        out.println("<input type='password' name='pass' placeholder='Enter password' required>");

        out.println("<button type='submit'>Login</button>");
        out.println("</form>");

        out.println("</div></div>");

        out.println("<footer class='footer'><p>© 2025 Khadri Mart</p></footer>");

        out.println("</body></html>");
    }
}
