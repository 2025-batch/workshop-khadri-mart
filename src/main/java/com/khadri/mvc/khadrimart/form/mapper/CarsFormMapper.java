package com.khadri.mvc.khadrimart.form.mapper;

import com.khadri.mvc.khadrimart.controller.form.CarsForm;
import com.khadri.mvc.khadrimart.service.dto.CarsDto;

public class CarsFormMapper {

    public CarsDto mapToDto(CarsForm form) {
        CarsDto dto = new CarsDto();
        dto.setCarName(form.getCarName());
        dto.setQuantity(form.getQuantity());
        dto.setColor(form.getColor());
        return dto;
    }
}

