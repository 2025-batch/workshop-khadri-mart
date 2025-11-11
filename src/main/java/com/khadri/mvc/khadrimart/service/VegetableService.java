package com.khadri.mvc.khadrimart.service;

import com.khadri.mvc.khadrimart.controller.form.VegetableForm;
import com.khadri.mvc.khadrimart.dao.VegetableDao;
import com.khadri.mvc.khadrimart.service.dto.VegetableDto;
import com.khadri.mvc.khadrimart.service.mapper.VegetableMapper;

public class VegetableService {
	private VegetableDao dao = new VegetableDao();
	private VegetableMapper mapper = new VegetableMapper();

	public int saveVegetable(VegetableForm form) {
		VegetableDto dto = mapper.map(form);
		return dao.insert(dto);
	}
}
