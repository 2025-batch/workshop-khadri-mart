package com.khadri.mvc.khadrimart.service;

import com.khadri.mvc.khadrimart.controller.form.SnacksForm;
import com.khadri.mvc.khadrimart.dao.SnacksDao;

public class SnacksService {

	private SnacksDao dao = new SnacksDao();

	public int saveSnack(SnacksForm form) {
		return dao.insertSnack(form);
	}
}
