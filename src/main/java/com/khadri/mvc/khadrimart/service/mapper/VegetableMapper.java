package com.khadri.mvc.khadrimart.service.mapper;

import com.khadri.mvc.khadrimart.controller.form.VegetableForm;
import com.khadri.mvc.khadrimart.service.dto.VegetableDto;

public class VegetableMapper {
    public VegetableDto map(VegetableForm form) {
        VegetableDto dto = new VegetableDto();
        dto.setVegname(form.getVegname());
        dto.setQuantity(form.getQuantity());
        dto.setUserName(form.getUserName());
        return dto;
    }
}
