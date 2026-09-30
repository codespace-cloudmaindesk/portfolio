package com.cloudstudio.portfolio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactMessageDto {

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be 100 characters or fewer")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email")
    @Size(max = 254, message = "Email must be 254 characters or fewer")
    private String email;

    @NotBlank(message = "Message is required")
    @Size(max = 2000, message = "Message must be 2000 characters or fewer")
    private String message;
}