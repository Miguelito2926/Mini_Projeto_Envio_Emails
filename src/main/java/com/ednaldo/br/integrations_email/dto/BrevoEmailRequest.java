package com.ednaldo.br.integrations_email.dto;
import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BrevoEmailRequest {

    private Sender sender;
    private List<To> to;
    private String subject;
    private String htmlContent;

    @Getter
    @Setter
    public static class Sender {
        private String email;
        private String name;
    }

    @Getter
    @Setter
    public static class To {
        private String email;
    }
}