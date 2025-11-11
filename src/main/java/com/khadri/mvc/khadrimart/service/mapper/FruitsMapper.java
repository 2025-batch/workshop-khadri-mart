package com.khadri.mvc.khadrimart.service.mapper;

import com.khadri.mvc.khadrimart.controller.form.FruitsForm;
import com.khadri.mvc.khadrimart.service.dto.FruitsDto;

public class FruitsMapper {
    public FruitsDto map(FruitsForm form) {
        FruitsDto dto = new FruitsDto();
        dto.setFruitname(form.getFruitname());
        dto.setQuantity(form.getQuantity());
        dto.setUserName(form.getUserName());
        return dto;
    }
}

