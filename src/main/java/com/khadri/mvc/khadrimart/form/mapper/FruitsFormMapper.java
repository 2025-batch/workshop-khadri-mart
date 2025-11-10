package com.khadri.mvc.khadrimart.form.mapper;

import com.khadri.mvc.khadrimart.controller.form.FruitsForm;
import com.khadri.mvc.khadrimart.service.dto.FruitsDto;

public class FruitsFormMapper {
    public FruitsDto map(FruitsForm form) {
        FruitsDto dto = new FruitsDto();
        dto.setFruitname(form.getFruitname());
        dto.setQuantity(form.getQuantity());
        return dto;
    }
}
