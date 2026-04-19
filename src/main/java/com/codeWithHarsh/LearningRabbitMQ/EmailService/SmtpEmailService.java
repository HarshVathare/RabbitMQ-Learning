package com.codeWithHarsh.LearningRabbitMQ.EmailService;

import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SmtpEmailService {

    private final JavaMailSender mailSender;

    public SmtpEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String firstName, String lastName) {

        try {
            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("medicore.owner@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);

            // 🔥 HTML Email
            String htmlContent = """
                <html>
                <body style="font-family: Arial;">

                    <div style="text-align:center;">
                        <img src='cid:logoImage' width='150'/>
                        <h2 style="color:green;">Appointment Confirmed ✅</h2>
                    </div>

                    <p>Dear %s %s,</p>

                    <p>Your appointment has been <b>successfully CONFIRMED</b>.</p>

                    <h3>🩺 Appointment Details:</h3>
                    <ul>
                        <li><b>Status:</b> Confirmed</li>
                        <li><b>Patient Name:</b> %s %s</li>
                    </ul>

                    <p>📌 Please arrive 10 minutes early.</p>
                    <p>📄 Carry necessary documents.</p>

                    <p>Thank you for choosing <b>MediCore</b> 💙</p>

                    <br>
                    <p>Best Regards,<br>MediCore Team</p>

                </body>
                </html>
                """.formatted(firstName, lastName, firstName, lastName);

            helper.setText(htmlContent, true);

            // 🔥 Attach logo (INLINE IMAGE)
            ClassPathResource image = new ClassPathResource("static/Medicore.png");
            helper.addInline("logoImage", image);

            mailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}