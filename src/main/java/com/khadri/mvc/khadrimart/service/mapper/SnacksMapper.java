package com.khadri.mvc.khadrimart.service.mapper;

import com.khadri.mvc.khadrimart.service.dto.SnacksDto;

public class SnacksMapper {

    public SnacksDto map(SnacksDto source) {
        SnacksDto target = new SnacksDto();
        target.setSnackName(source.getSnackName());
        target.setQuantity(source.getQuantity());
        return target;
    }
}
