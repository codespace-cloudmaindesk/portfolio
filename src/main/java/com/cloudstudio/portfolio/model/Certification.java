package com.cloudstudio.portfolio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Certification {
    private String name;
    private String issuer;
    private String issueDate;
    private String expirationDate;
    private String credentialId;
    private String credentialUrl;
}