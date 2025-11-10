package com.khadri.mvc.khadrimart.service.mapper;

import com.khadri.mvc.khadrimart.service.dto.ClothesDto;

public class ClothesMapper {

    public ClothesDto mapDto(ClothesDto dto) {
        ClothesDto mapped = new ClothesDto();
        mapped.setClothName(dto.getClothName());
        mapped.setQuantity(dto.getQuantity());
        return mapped;
    }
}

