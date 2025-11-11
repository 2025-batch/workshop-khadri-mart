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

	public void init() throws ServletException {
		service = new FruitsService();

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

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		try {
			String fruitname = req.getParameter("fruitname");
			String qtyStr = req.getParameter("quantity");

			String userName = "Khadri";
			double quantity = Double.parseDouble(qtyStr);

			FruitsForm form = new FruitsForm();
			form.setFruitname(fruitname);
			form.setQuantity(quantity);
			form.setUserName(userName);

			int result = service.saveFruits(form);

			if (result > 0) {
				pw.println("Added Successfull");
			} else {
				pw.println("Invalid");
			}

		} catch (Exception e) {
			e.printStackTrace();
			pw.println("Error");
		}
	}
}
