package com.khadri.mvc.khadrimart.form.mapper;

import com.khadri.mvc.khadrimart.service.dto.FruitsDto;

public class FruitsFormMapper {

	public FruitsDto map(String fruitname, double quantity, String userName) {
		FruitsDto dto = new FruitsDto();
		dto.setFruitname(fruitname);
		dto.setQuantity(quantity);
		dto.setUserName(userName);
		return dto;
	}
}
