package com.khadri.mvc.khadrimart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.mvc.khadrimart.controller.form.CarsForm;
import com.khadri.mvc.khadrimart.form.mapper.CarsFormMapper;
import com.khadri.mvc.khadrimart.service.CarsService;
import com.khadri.mvc.khadrimart.service.dto.CarsDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saveCar")
public class CarsServlet extends HttpServlet {
    
    private CarsService service = new CarsService();
    private CarsFormMapper mapper = new CarsFormMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        CarsForm form = new CarsForm();
        form.setCarName(req.getParameter("carname"));
        form.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        form.setColor(req.getParameter("color"));

        CarsDto dto = mapper.mapToDto(form);

        int result = service.saveCar(dto);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if (result > 0) {
            out.println("<h2 style='color:green;'>Car saved successfully!</h2>");
        } else {
            out.println("<h2 style='color:red;'>Failed to save car!</h2>");
        }
    }
}
