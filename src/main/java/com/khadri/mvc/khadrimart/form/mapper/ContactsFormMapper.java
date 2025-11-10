package com.khadri.mvc.khadrimart.form.mapper;

import com.khadri.mvc.khadrimart.controller.form.ContactsForm;
import com.khadri.mvc.khadrimart.service.dto.ContactsDto;

public class ContactsFormMapper {

    public ContactsDto mapToDto(ContactsForm form) {
        ContactsDto dto = new ContactsDto();
        dto.setName(form.getName());
        dto.setEmail(form.getEmail());
        dto.setMessage(form.getMessage());
        return dto;
    }
}

