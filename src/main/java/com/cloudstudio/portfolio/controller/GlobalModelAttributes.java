package com.cloudstudio.portfolio.controller;

import com.cloudstudio.portfolio.model.SocialLink;
import com.cloudstudio.portfolio.service.SocialLinkService;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class GlobalModelAttributes {

    private final SocialLinkService socialLinkService;

    public GlobalModelAttributes(SocialLinkService socialLinkService) {
        this.socialLinkService = socialLinkService;
    }

    @ModelAttribute("socialLinks")
    public List<SocialLink> socialLinks() {
        return socialLinkService.getAllSocialLinks();
    }
}