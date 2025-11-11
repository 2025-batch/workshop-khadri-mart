package com.khadri.mvc.khadrimart.service.mapper;

import com.khadri.mvc.khadrimart.service.dto.ContactsDto;

public class ContactsMapper {

    public ContactsDto mapDto(ContactsDto dto) {
        ContactsDto mapped = new ContactsDto();
        mapped.setName(dto.getName());
        mapped.setEmail(dto.getEmail());
        mapped.setMessage(dto.getMessage());
        return mapped;
    }
}

