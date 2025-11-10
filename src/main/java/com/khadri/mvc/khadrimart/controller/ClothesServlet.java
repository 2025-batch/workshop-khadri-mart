package com.khadri.mvc.khadrimart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.mvc.khadrimart.controller.form.ClothesForm;
import com.khadri.mvc.khadrimart.form.mapper.ClothesFormMapper;
import com.khadri.mvc.khadrimart.service.ClothesService;
import com.khadri.mvc.khadrimart.service.dto.ClothesDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clothes")
public class ClothesServlet extends HttpServlet {

    private ClothesService service = new ClothesService();
    private ClothesFormMapper mapper = new ClothesFormMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String clothName = req.getParameter("clothname");
        String quantity = req.getParameter("quantity");

        ClothesForm form = new ClothesForm();
        form.setClothName(clothName);
        form.setQuantity(Integer.parseInt(quantity));

        ClothesDto dto = mapper.mapToDto(form);
        int count = service.saveCloth(dto);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if (count > 0) {
            out.println("<h2>Cloth added successfully!</h2>");
        } else {
            out.println("<h2>Failed to add cloth!</h2>");
        }
    }
}
