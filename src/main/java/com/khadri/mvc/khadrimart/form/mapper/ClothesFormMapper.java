package com.khadri.mvc.khadrimart.form.mapper;

import com.khadri.mvc.khadrimart.controller.form.ClothesForm;
import com.khadri.mvc.khadrimart.service.dto.ClothesDto;

public class ClothesFormMapper {

	public ClothesDto mapToDto(ClothesForm form) {
		ClothesDto dto = new ClothesDto();
		dto.setClothName(form.getClothName());
		dto.setQuantity(form.getQuantity());
		dto.setUserName(form.getUserName());
		return dto;
	}
}
