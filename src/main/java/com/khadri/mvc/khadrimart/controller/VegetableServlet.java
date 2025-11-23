
package com.khadri.mvc.khadrimart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.mvc.khadrimart.connection.DBConnection;
import com.khadri.mvc.khadrimart.controller.form.VegetableForm;
import com.khadri.mvc.khadrimart.form.mapper.VegetableFormMapper;
import com.khadri.mvc.khadrimart.service.VegetableService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VegetableServlet extends HttpServlet {

    private VegetableService service;
    private VegetableFormMapper mapper;

    public void init() throws ServletException {
        service = new VegetableService();
        mapper = new VegetableFormMapper();
        
        ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        DBConnection.createConnection(driver, url, username, password);
        if (DBConnection.getConnection() != null) {
            System.out.println("Database connection successful!");
        } else {
            System.err.println("Database connection failed!");
        }
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();

        try {
            String vegname = req.getParameter("vegname");
            String qtyStr = req.getParameter("quantity");
            String userName = "Khadri";

            double quantity = Double.parseDouble(qtyStr);

            VegetableForm form = mapper.map(vegname, quantity, userName);
            int result = service.saveVegetable(form);

            if (result > 0) {
                pw.println("Success");
            } else {
                pw.println("Invalid");
            }

        } catch (Exception e) {
            pw.println("Error occurred: " );
        }
    }
}
