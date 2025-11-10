package com.khadri.mvc.khadrimart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.mvc.khadrimart.controller.form.SnacksForm;
import com.khadri.mvc.khadrimart.form.mapper.SnacksFormMapper;
import com.khadri.mvc.khadrimart.service.SnacksService;
import com.khadri.mvc.khadrimart.service.dto.SnacksDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/snacks")
public class SnacksServlet extends HttpServlet {

    private SnacksService service = new SnacksService();
    private SnacksFormMapper mapper = new SnacksFormMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String snackName = req.getParameter("snackname");
        String quantity = req.getParameter("quantity");

        SnacksForm form = new SnacksForm();
        form.setSnackName(snackName);
        form.setQuantity(Double.parseDouble(quantity));

        SnacksDto dto = mapper.mapToDto(form);

        int count = service.saveSnack(dto);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if (count > 0) {
            out.println("<h2>Snack Added Successfully!</h2>");
        } else {
            out.println("<h2>Failed to Add Snack!</h2>");
        }
    }
}
