package com.khadri.mvc.khadrimart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.mvc.khadrimart.connection.DBConnection;
import com.khadri.mvc.khadrimart.controller.form.CarsForm;
import com.khadri.mvc.khadrimart.service.CarsService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CarsServlet extends HttpServlet {

	private CarsService service;

	public void init() throws ServletException {
		service = new CarsService();

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

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		try {
			String carName = req.getParameter("carname");
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			String color = req.getParameter("color");
			String userName = "Khadri";

			CarsForm form = new CarsForm();
			form.setCarName(carName);
			form.setQuantity(quantity);
			form.setColor(color);
			form.setUserName(userName);

			int result = service.saveCar(form);

			if (result > 0) {
				pw.println("Success");
			} else {
				pw.println("Invalid");
			}

		} catch (Exception e) {
			e.printStackTrace();
			pw.println("Error occurred: ");
		}
	}
}