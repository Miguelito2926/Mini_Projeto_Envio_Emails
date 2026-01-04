package com.ednaldo.br.integrations_email.controllers;


import com.ednaldo.br.integrations_email.dto.EmailDTO;
import com.ednaldo.br.integrations_email.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/emails")
public class EmailResource {

	@Autowired
	private EmailService service;
	
	@PostMapping
	public ResponseEntity<EmailDTO> insert(@RequestBody EmailDTO dto) {
		service.sendPlainTextEmail(dto);
		return ResponseEntity.noContent().build();
	}
}
