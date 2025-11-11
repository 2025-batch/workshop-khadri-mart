package com.khadri.mvc.khadrimart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.mvc.khadrimart.connection.DBConnection;
import com.khadri.mvc.khadrimart.controller.form.SnacksForm;
import com.khadri.mvc.khadrimart.service.SnacksService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SnacksServlet extends HttpServlet {

    private SnacksService service;

    @Override
    public void init() throws ServletException {
        service = new SnacksService();

        // Get DB parameters from web.xml
        ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        DBConnection.createConnection(driver, url, username, password);

        if (DBConnection.getConnection() != null) {
            System.out.println(" Database connectiond");
        } else {
            System.out.println("Database failed!");
        }
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        try {
            String snackName = req.getParameter("snackname");
            String qtyStr = req.getParameter("quantity");

            String userName = "Khadri";

            double quantity = Double.parseDouble(qtyStr);

            SnacksForm form = new SnacksForm();
            form.setSnackName(snackName);
            form.setQuantity(quantity);
            form.setUserName(userName);

            int result = service.saveSnack(form);

            if (result > 0) {
                pw.println("<h2>Snack Added Successfully!</h2>");
            } else {
                pw.println("<h2>Failed to Add Snack!</h2>");
            }

        } catch (Exception e) {
            System.out.println("error Occured");
        }
    }
}
