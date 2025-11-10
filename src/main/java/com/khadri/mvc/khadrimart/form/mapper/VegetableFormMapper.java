package com.khadri.mvc.khadrimart.form.mapper;

import com.khadri.mvc.khadrimart.controller.form.VegetableForm;

public class VegetableFormMapper {
	public VegetableForm map(String vegname, double quantity) {
        VegetableForm form = new VegetableForm();
        form.setVegname(vegname);
        form.setQuantity(quantity);
        return form;
    }
}
