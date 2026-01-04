package com.ednaldo.br.integrations_email.services;


import com.ednaldo.br.integrations_email.dto.EmailDTO;

public interface EmailService {

	void sendPlainTextEmail(EmailDTO dto);
}
