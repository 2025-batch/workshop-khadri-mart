package com.khadri.mvc.khadrimart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.mvc.khadrimart.controller.form.ContactsForm;
import com.khadri.mvc.khadrimart.form.mapper.ContactsFormMapper;
import com.khadri.mvc.khadrimart.service.ContactsService;
import com.khadri.mvc.khadrimart.service.dto.ContactsDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContactsServlet extends HttpServlet {

	private ContactsService service = new ContactsService();
	private ContactsFormMapper mapper = new ContactsFormMapper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ContactsForm form = new ContactsForm();
		form.setName(req.getParameter("name"));
		form.setEmail(req.getParameter("email"));
		form.setMessage(req.getParameter("message"));

		ContactsDto dto = mapper.mapToDto(form);
		int result = service.saveContact(dto);

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		if (result > 0) {
			out.println("<h2 style='color:green;'>Thank you! We’ve received your message.</h2>");
		} else {
			out.println("<h2 style='color:red;'>Failed to send your message. Please try again.</h2>");
		}
	}
}
