package com.khadri.mvc.khadrimart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.mvc.khadrimart.connection.DBConnection;
import com.khadri.mvc.khadrimart.controller.form.FruitsForm;
import com.khadri.mvc.khadrimart.service.FruitsService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FruitsServlet extends HttpServlet {
    private FruitsService service;

    @Override
    public void init() throws ServletException {
        service = new FruitsService();

        ServletContext context = getServletContext();
        String un = context.getInitParameter("username");
        String pwd = context.getInitParameter("password");
        String url = context.getInitParameter("url");
        String driver = context.getInitParameter("driver");

        DBConnection.createConnection(driver, url, un, pwd);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        String fruitname = req.getParameter("fruitname");
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        FruitsForm form = new FruitsForm();
        form.setFruitname(fruitname);
        form.setQuantity(quantity);

        int result = service.saveFruit(form);

        if (result > 0) pw.println("Order placed successfully!");
        else pw.println("Order failed!");
    }
}

