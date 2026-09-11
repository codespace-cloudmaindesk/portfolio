package com.cloudstudio.portfolio.mapper;

import com.cloudstudio.portfolio.dto.ContactMessageDto;
import com.cloudstudio.portfolio.entity.ContactMessage;

public class ContactMessageMapper {

    public static ContactMessage toEntity(ContactMessageDto dto) {
        ContactMessage contactMessage = new ContactMessage();
        contactMessage.setName(dto.getName());
        contactMessage.setEmail(dto.getEmail());
        contactMessage.setMessage(dto.getMessage());
        return contactMessage;
    }
}