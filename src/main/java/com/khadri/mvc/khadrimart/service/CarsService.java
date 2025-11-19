package com.khadri.mvc.khadrimart.service;

import com.khadri.mvc.khadrimart.controller.form.CarsForm;
import com.khadri.mvc.khadrimart.dao.CarsDao;
import com.khadri.mvc.khadrimart.service.dto.CarsDto;
import com.khadri.mvc.khadrimart.service.mapper.CarsMapper;

public class CarsService {

	private final CarsDao dao = new CarsDao();
	private final CarsMapper mapper = new CarsMapper();

	public int saveCar(CarsForm form) {
		CarsDto dto = mapper.map(form);
		return dao.saveCar(dto);
	}
}
