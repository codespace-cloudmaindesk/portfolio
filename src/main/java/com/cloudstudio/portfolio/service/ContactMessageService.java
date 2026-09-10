package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.entity.ContactMessage;

import java.util.List;

public interface ContactMessageService {
    List<ContactMessage> getAllContactMessages();
    ContactMessage saveMessage(ContactMessage contactMessage);
}
