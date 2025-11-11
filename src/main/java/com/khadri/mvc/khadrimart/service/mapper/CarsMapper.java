package com.khadri.mvc.khadrimart.service.mapper;

import com.khadri.mvc.khadrimart.controller.form.CarsForm;
import com.khadri.mvc.khadrimart.service.dto.CarsDto;

public class CarsMapper {

    public CarsDto map(CarsForm form) {
        CarsDto dto = new CarsDto();
        dto.setCarName(form.getCarName());
        dto.setQuantity(form.getQuantity());
        dto.setColor(form.getColor());
        dto.setUserName(form.getUserName());
        return dto;
    }
}
