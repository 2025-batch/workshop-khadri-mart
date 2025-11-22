package com.khadri.mvc.khadrimart.controller;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login");
            return;
        }

        String username = (String) session.getAttribute("user");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Khadri Mart</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("<link rel='stylesheet' href='header.css'>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin:0; background-color:pink; }");
        out.println("header { text-align:center; padding:20px; color:white; background: linear-gradient(to right, #5f9ea0, #4682b4); }");
        out.println("nav { display:flex; justify-content:center; background-color:#f0f0f0; border-bottom:2px solid #444; position:relative; }");
        out.println(".dropdown { position: relative; }");
        out.println(".dropdown a { display:block; padding:10px 20px; text-decoration:none; color:black; font-weight:bold; }");
        out.println(".dropdown-content { display:none; position:absolute; top:100%; left:0; background-color:#f0f0f0; border:1px solid #ccc; border-radius:4px; min-width:160px; z-index:10; }");
        out.println(".dropdown:hover .dropdown-content { display:block; }");
        out.println(".dropdown-content a { display:block; padding:10px; color:black; text-align:left; text-decoration:none; }");
        out.println(".dropdown-content a:hover { background-color:#ddd; }");
        out.println("iframe { width:80%; height:450px; border:none; display:block; margin:20px auto; }");
        out.println("footer { text-align:center; background-color:#4682b4; color:white; padding:10px; }");
        out.println("</style>");
        out.println("<script>");
        out.println("function logout(){ window.location.href='logout'; }");
        out.println("</script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<header>");
        out.println("<div class='header-container'>");
        out.println("<div class='header-left'>");
        out.println("<h1>Khadri Mart</h1>");
        out.println("<p>Welcome to your fresh vegetable store!</p>");
        out.println("</div>");
        out.println("<div class='header-right'>");
        out.println("<span class='username'>Hello, <strong>" + username + "</strong></span>");
        out.println("<button class='logout-btn' onclick='logout()'>Logout</button>");
        out.println("</div></div>");
        out.println("</header>");
        out.println("<nav>");
        
        out.println("<div class='dropdown'><a href='#'>VEGETABLES ▾</a><div class='dropdown-content'>");
        out.println("<a href='vegetables.html#tomato' target='content-frame'>Tomato</a>");
        out.println("<a href='vegetables.html#onion' target='content-frame'>Onion</a>");
        out.println("<a href='vegetables.html#carrot' target='content-frame'>Carrot</a>");
        out.println("</div></div>");
        
        out.println("<div class='dropdown'><a href='#'>FRUITS ▾</a><div class='dropdown-content'>");
        out.println("<a href='fruits.html#apple' target='content-frame'>Apple</a>");
        out.println("<a href='fruits.html#banana' target='content-frame'>Banana</a>");
        out.println("<a href='fruits.html#mango' target='content-frame'>Mango</a>");
        out.println("</div></div>");
        
        out.println("<div class='dropdown'><a href='#'>CARS ▾</a><div class='dropdown-content'>");
        out.println("<a href='cars.html#tesla' target='content-frame'>Tesla Model S</a>");
        out.println("<a href='cars.html#bmw' target='content-frame'>BMW X5</a>");
        out.println("<a href='cars.html#audi' target='content-frame'>Audi A6</a>");
        out.println("</div></div>");
        
        out.println("<div class='dropdown'><a href='#'>SNACKS ▾</a><div class='dropdown-content'>");
        out.println("<a href='snacks.html#chips' target='content-frame'>Potato Chips</a>");
        out.println("<a href='snacks.html#samosa' target='content-frame'>Samosa</a>");
        out.println("<a href='snacks.html#popcorn' target='content-frame'>Popcorn</a>");
        out.println("</div></div>");
        
        out.println("<div class='dropdown'><a href='#'>CLOTHES ▾</a><div class='dropdown-content'>");
        out.println("<a href='clothes.html#shirt' target='content-frame'>Shirt</a>");
        out.println("<a href='clothes.html#jeans' target='content-frame'>Jeans</a>");
        out.println("<a href='clothes.html#jacket' target='content-frame'>Jacket</a>");
        out.println("</div></div>");
        
        out.println("<a href='contact.html' target='content-frame'>CONTACT</a>");
        out.println("</nav>");
        out.println("<iframe name='content-frame'></iframe>");
        out.println("<footer><p>&copy; 2025 Khadri Mart. All Rights Reserved.</p></footer>");
        out.println("</body></html>");
    }
}
