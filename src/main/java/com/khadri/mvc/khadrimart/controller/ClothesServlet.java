package com.khadri.mvc.khadrimart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.mvc.khadrimart.connection.DBConnection;
import com.khadri.mvc.khadrimart.controller.form.ClothesForm;
import com.khadri.mvc.khadrimart.form.mapper.ClothesFormMapper;
import com.khadri.mvc.khadrimart.service.ClothesService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ClothesServlet extends HttpServlet {

	private ClothesService service;
	private ClothesFormMapper mapper;

	public void init() throws ServletException {
		service = new ClothesService();
		mapper = new ClothesFormMapper();

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
			String clothName = req.getParameter("clothname");
			String quantityStr = req.getParameter("quantity");
			String userName = "Khadri";

			int quantity = Integer.parseInt(quantityStr);

			ClothesForm form = new ClothesForm();
			form.setClothName(clothName);
			form.setQuantity(quantity);
			form.setUserName(userName);

			int result = service.saveCloth(form);

			if (result > 0) {
				pw.println("Success");
			} else {
				pw.println("Invalid");
			}

		} catch (Exception e) {
			e.printStackTrace();
			pw.println("Error occurred: " + e.getMessage());
		}
	}
}
