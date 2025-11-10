package com.khadri.mvc.khadrimart.service.mapper;

import com.khadri.mvc.khadrimart.service.dto.CarsDto;

public class CarsMapper {

    public CarsDto mapDto(CarsDto dto) {
        CarsDto mapped = new CarsDto();
        mapped.setCarName(dto.getCarName());
        mapped.setQuantity(dto.getQuantity());
        mapped.setColor(dto.getColor());
        return mapped;
    }
}

