package com.khadri.mvc.khadrimart.service;

import com.khadri.mvc.khadrimart.dao.SnacksDao;
import com.khadri.mvc.khadrimart.service.dto.SnacksDto;

public class SnacksService {
    private SnacksDao dao = new SnacksDao();

    public int saveSnack(SnacksDto dto) {
        return dao.insertSnack(dto);
    }
}
