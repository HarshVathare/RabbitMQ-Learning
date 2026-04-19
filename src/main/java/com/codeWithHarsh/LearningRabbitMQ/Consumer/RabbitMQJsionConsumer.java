package com.codeWithHarsh.LearningRabbitMQ.Consumer;

import com.codeWithHarsh.LearningRabbitMQ.DTO.User;

import com.codeWithHarsh.LearningRabbitMQ.EmailService.SmtpEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsionConsumer {

    private final SmtpEmailService emailService;

    public RabbitMQJsionConsumer(SmtpEmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = {"${rabbitmq.jsion.queue.name}"})
    public void JesionConsumer(User user) {
        log.info(String.format("Received Jsion message -> %s", user.toString()));

        // 🔥 Send Email
        emailService.sendEmail(
                user.getEmail(),
                "✅ Appointment Status | MediCore",
                user.getFirstName(),
                user.getLastName()
        );




//        emailService.sendEmail(
//                user.getEmail(),
//                "✅ Appointment Status | MediCore",
//                "Dear " + user.getFirstName() + " " + user.getLastName() + ",\n\n" +
//                        "We are pleased to inform you that your appointment has been successfully CONFIRMED.\n\n" +
//
//                        "🩺 Appointment Details:\n" +
//                        "-----------------------------------\n" +
//                        "Status       : CONFIRMED\n" +
//                        "Patient Name : " + user.getFirstName() + " " + user.getLastName() + "\n" +
//                        "-----------------------------------\n\n" +
//
//                        "📌 Please arrive at least 10 minutes before your scheduled time.\n" +
//                        "📄 Carry necessary medical documents if applicable.\n\n" +
//
//                        "If you have any questions or need to reschedule, feel free to contact us.\n\n" +
//
//                        "Thank you for choosing MediCore.\n" +
//                        "We wish you good health! 💙\n\n" +
//
//                        "Best Regards,\n" +
//                        "MediCore Team\n" +
//                        "📧 support@medicore.com"
//        );
    }
}
