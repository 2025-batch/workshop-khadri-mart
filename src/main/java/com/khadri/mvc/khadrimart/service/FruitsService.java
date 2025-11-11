package com.khadri.mvc.khadrimart.service;

import com.khadri.mvc.khadrimart.controller.form.FruitsForm;
import com.khadri.mvc.khadrimart.dao.FruitsDao;
import com.khadri.mvc.khadrimart.service.dto.FruitsDto;
import com.khadri.mvc.khadrimart.form.mapper.FruitsFormMapper;

public class FruitsService {

	private FruitsDao dao = new FruitsDao();
	private FruitsFormMapper mapper = new FruitsFormMapper();

	public int saveFruits(FruitsForm form) {
		FruitsDto dto = mapper.map(form.getFruitname(), form.getQuantity(), form.getUserName());
		return dao.insert(dto);
	}
}
