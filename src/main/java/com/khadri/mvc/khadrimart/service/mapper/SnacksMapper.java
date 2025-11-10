package com.khadri.mvc.khadrimart.service.mapper;

import com.khadri.mvc.khadrimart.service.dto.SnacksDto;

public class SnacksMapper {

    public SnacksDto mapDto(SnacksDto dto) {
        SnacksDto mapped = new SnacksDto();
        mapped.setSnackName(dto.getSnackName());
        mapped.setQuantity(dto.getQuantity());
        return mapped;
    }
}

