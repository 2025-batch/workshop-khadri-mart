package com.khadri.mvc.khadrimart.service.mapper;

import com.khadri.mvc.khadrimart.controller.form.ClothesForm;
import com.khadri.mvc.khadrimart.service.dto.ClothesDto;

public class ClothesMapper {

    public ClothesDto map(ClothesForm form) {
        ClothesDto dto = new ClothesDto();
        dto.setClothName(form.getClothName());
        dto.setQuantity(form.getQuantity());
        dto.setUserName(form.getUserName());
        return dto;
    }
}
