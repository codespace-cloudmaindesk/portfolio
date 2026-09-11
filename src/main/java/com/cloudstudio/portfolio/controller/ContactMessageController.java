package com.cloudstudio.portfolio.controller;

import com.cloudstudio.portfolio.dto.ContactMessageDto;
import com.cloudstudio.portfolio.entity.ContactMessage;
import com.cloudstudio.portfolio.mapper.ContactMessageMapper;
import com.cloudstudio.portfolio.service.ContactMessageService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    public ContactMessageController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contactMessageDto", new ContactMessageDto());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(
            @Valid @ModelAttribute("contactMessageDto") ContactMessageDto dto,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "contact";
        }

        ContactMessage contactMessage = ContactMessageMapper.toEntity(dto);
        contactMessageService.saveMessage(contactMessage);

        model.addAttribute("successMessage", "Thank you for your message!");
        model.addAttribute("contactMessageDto", new ContactMessageDto());
        return "contact";
    }
}