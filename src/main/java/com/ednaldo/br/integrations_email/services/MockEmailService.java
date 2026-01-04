package com.ednaldo.br.integrations_email.services;

import com.ednaldo.br.integrations_email.dto.EmailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MockEmailService implements EmailService {

	private Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	public void sendPlainTextEmail(EmailDTO dto) {
		LOG.info("Email sent to: " + dto.getTo());
	}
}
