//package com.codeWithHarsh.LearningRabbitMQ.EmailService;
//
//import kong.unirest.Unirest;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import kong.unirest.HttpResponse;
//
//
//@Service
//@Slf4j
//public class MailgunEmailService {
//
//    @Value("${mailgun.api.key}")
//    private String apiKey;
//
//    @Value("${mailgun.domain}")
//    private String domain;
//
//    @Value("${mailgun.from.email}")
//    private String fromEmail;
//
//    public void sendEmail(String toEmail, String subject, String text) {
//
//        try {
//            HttpResponse<String> response = Unirest.post("https://api.mailgun.net/v3/" + domain + "/messages")
//                    .basicAuth("api", apiKey)
//                    .field("from", fromEmail)
//                    .field("to", toEmail)
//                    .field("subject", subject)
//                    .field("text", text)
//                    .asString();
//
//            log.info("Email sent: {}", response.getBody());
//
//        } catch (Exception e) {
//            log.error("Email sending failed", e);
//        }
//    }
//}