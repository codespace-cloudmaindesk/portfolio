package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.entity.ContactMessage;
import com.cloudstudio.portfolio.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageServiceImpl implements ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    public ContactMessageServiceImpl(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }
    
    @Override
    public List<ContactMessage> getAllContactMessages() {
        return contactMessageRepository.findAll();
    }

    @Override
    public ContactMessage saveMessage(ContactMessage contactMessage) {
        return contactMessageRepository.save(contactMessage);
    }
}
