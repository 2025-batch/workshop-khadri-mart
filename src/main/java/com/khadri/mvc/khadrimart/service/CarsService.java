package com.khadri.mvc.khadrimart.service;

import com.khadri.mvc.khadrimart.dao.CarsDao;
import com.khadri.mvc.khadrimart.service.dto.CarsDto;

public class CarsService {

    private CarsDao dao = new CarsDao();

    public int saveCar(CarsDto dto) {
        // any business logic (validation, calculations, etc.) can go here
        return dao.saveCar(dto);
    }
}
