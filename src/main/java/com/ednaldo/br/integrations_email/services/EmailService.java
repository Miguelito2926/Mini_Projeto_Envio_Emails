package com.ednaldo.br.integrations_email.services;

import com.ednaldo.br.integrations_email.dto.BrevoEmailRequest;
import com.ednaldo.br.integrations_email.dto.EmailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class EmailService {

    private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);

    private static final String BREVO_ENDPOINT =
            "https://api.brevo.com/v3/smtp/email";

    @Value("${brevo.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public void sendEmail(EmailDTO dto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-key", apiKey);

        // === Equivalente ao Mail mail = new Mail(...) ===
        BrevoEmailRequest brevoRequest = new BrevoEmailRequest();

        BrevoEmailRequest.Sender sender =
                new BrevoEmailRequest.Sender();
        sender.setEmail(dto.getFromEmail());
        sender.setName(dto.getFromName());

        BrevoEmailRequest.To to =
                new BrevoEmailRequest.To();
        to.setEmail(dto.getTo());

        brevoRequest.setSender(sender);
        brevoRequest.setTo(List.of(to));
        brevoRequest.setSubject(dto.getSubject());
        brevoRequest.setHtmlContent(dto.getBody());

        HttpEntity<BrevoEmailRequest> request =
                new HttpEntity<>(brevoRequest, headers);

        try {
            LOG.info("Sending email to: {}", dto.getTo());

            ResponseEntity<String> response =
                    restTemplate.postForEntity(
                            BREVO_ENDPOINT,
                            request,
                            String.class
                    );

            if (response.getStatusCode().isError()) {
                LOG.error("Error sending email: {}", response.getBody());
            } else {
                LOG.info("Email sent! Status = {}",
                        response.getStatusCodeValue());
            }

        } catch (Exception e) {
            LOG.error("Exception sending email", e);
        }
    }
}
