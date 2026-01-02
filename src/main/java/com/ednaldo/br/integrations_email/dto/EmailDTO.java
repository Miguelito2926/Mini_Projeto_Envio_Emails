package com.ednaldo.br.integrations_email.dto;

import lombok.Data;


@Data
public class EmailDTO {

    private String fromEmail;
    private String fromName;
    private String replyTo;
    private String to;
    private String subject;
    private String body;
    private String contentType;
}
