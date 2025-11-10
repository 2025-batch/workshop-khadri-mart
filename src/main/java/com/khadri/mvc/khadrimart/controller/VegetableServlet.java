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

    @Override
    public void init() throws ServletException {
        service = new VegetableService();
        mapper = new VegetableFormMapper();

        ServletContext context = getServletContext();
        String un = context.getInitParameter("username");
        String pwd = context.getInitParameter("password");
        String url = context.getInitParameter("url");
        String driver = context.getInitParameter("driver");

        DBConnection.createConnection(driver, url, un, pwd);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("VegetableServlet invoked");

        PrintWriter pw = resp.getWriter();

        try {
            String vegname = req.getParameter("vegname");
            String qtyStr = req.getParameter("quantity");

            double quantity = Double.parseDouble(qtyStr);

            VegetableForm form = mapper.map(vegname, quantity);
            int result = service.saveVegetable(form);

            if (result > 0) {
                pw.println("Successfull");
            } else {
                pw.println("Invalid");
            }

        } catch (Exception e) {
            e.printStackTrace();
            pw.println("error occured");
        }
    }
}
