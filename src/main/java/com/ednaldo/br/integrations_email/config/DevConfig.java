package com.ednaldo.br.integrations_email.config;

import com.ednaldo.br.integrations_email.services.EmailService;
import com.ednaldo.br.integrations_email.services.SendGridEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



@Configuration
@Profile("dev")
public class DevConfig {

	@Bean
	EmailService emailService() {
		return new SendGridEmailService();
	}
}
