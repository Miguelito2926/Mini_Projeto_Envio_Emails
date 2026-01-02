package com.ednaldo.br.integrations_email.controllers;

import com.ednaldo.br.integrations_email.dto.EmailDTO;
import com.ednaldo.br.integrations_email.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/emails")
public class EmailController {
    
    private final EmailService emailService;
    
    @PostMapping
    public ResponseEntity<Void> send(@RequestBody EmailDTO dto) {
    //    emailService.sendEmail(dto);
        return ResponseEntity.noContent().build();
    }
}
