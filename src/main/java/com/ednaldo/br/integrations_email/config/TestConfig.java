package com.ednaldo.br.integrations_email.config;

import com.ednaldo.br.integrations_email.services.EmailService;
import com.ednaldo.br.integrations_email.services.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	EmailService emailService() {
		return new MockEmailService();
	}
}
