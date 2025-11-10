package com.khadri.mvc.khadrimart.service;

import com.khadri.mvc.khadrimart.dao.ContactsDao;
import com.khadri.mvc.khadrimart.service.dto.ContactsDto;

public class ContactsService {

    private ContactsDao dao = new ContactsDao();

    public int saveContact(ContactsDto dto) {
        // (Optional) Add any business logic like validation
        return dao.saveContact(dto);
    }
}

