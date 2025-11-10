package com.khadri.mvc.khadrimart.service;

import com.khadri.mvc.khadrimart.controller.form.FruitsForm;
import com.khadri.mvc.khadrimart.dao.FruitsDao;
import com.khadri.mvc.khadrimart.service.dto.FruitsDto;
import com.khadri.mvc.khadrimart.service.mapper.FruitsMapper;

public class FruitsService {
    private FruitsDao dao = new FruitsDao();
    private FruitsMapper mapper = new FruitsMapper();

    public int saveFruit(FruitsForm form) {
        FruitsDto dto = mapper.map(form);
        return dao.insert(dto);
    }
}


