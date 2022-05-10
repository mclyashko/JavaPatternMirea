package ru.mirea.task24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.mirea.task24.configuration.EmailConfiguration;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Service
public class EmailService {
    public static final String EMAIL = "jtask21@rambler.ru";

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendNotification(Object o) throws MailException {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(EMAIL);
        mail.setFrom(EMAIL);
        mail.setSubject(
                "Object " + o.getClass().getSimpleName() + " time " +
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(LocalDateTime.now())
        );
        mail.setText(o.toString());

        javaMailSender.send(mail);
    }
}
