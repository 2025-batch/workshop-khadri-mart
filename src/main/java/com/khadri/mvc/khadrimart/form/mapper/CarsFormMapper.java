package com.khadri.mvc.khadrimart.form.mapper;

import com.khadri.mvc.khadrimart.controller.form.CarsForm;

public class CarsFormMapper {

	public CarsForm map(String carname, double quantity, String color, String userName) {
		CarsForm form = new CarsForm();
		form.setCarName(form.getCarName());
		form.setQuantity(form.getQuantity());
		form.setColor(form.getColor());
		form.setUserName(userName);
		return form;
	}
}
