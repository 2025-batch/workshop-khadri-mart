package com.khadri.mvc.khadrimart.form.mapper;

import com.khadri.mvc.khadrimart.controller.form.SnacksForm;
import com.khadri.mvc.khadrimart.service.dto.SnacksDto;

public class SnacksFormMapper {

	public SnacksDto mapToDto(SnacksForm form) {
		SnacksDto dto = new SnacksDto();
		dto.setSnackName(form.getSnackName());
		dto.setQuantity(form.getQuantity());
		return dto;
	}
}
