package com.khadri.mvc.khadrimart.service;

import com.khadri.mvc.khadrimart.dao.ClothesDao;
import com.khadri.mvc.khadrimart.controller.form.ClothesForm;
import com.khadri.mvc.khadrimart.service.dto.ClothesDto;
import com.khadri.mvc.khadrimart.service.mapper.ClothesMapper;

public class ClothesService {

	private ClothesDao dao = new ClothesDao();
	private ClothesMapper mapper = new ClothesMapper();

	public int saveCloth(ClothesForm form) {
		ClothesDto dto = mapper.map(form);
		return dao.insertCloth(dto);
	}
}
