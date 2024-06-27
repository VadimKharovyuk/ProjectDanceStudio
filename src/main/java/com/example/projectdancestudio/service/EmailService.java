package com.example.projectdancestudio.service;

import com.example.projectdancestudio.model.Client;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmailService {

    private  final JavaMailSender mailSender;


    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    public void sendWelcomeEmail(Client client) {
        String subject = "Добро пожаловать в нашу школу танцев!";
        String text = "Уважаемый(ая) " + client.getName() + ",\n\n" +
                "Мы рады приветствовать вас в нашей школе танцев! Спасибо за регистрацию.\n" +
                "Вы стали частью нашего сообщества, где мы стремимся предоставлять высококачественное обучение танцам и поддержку.\n\n" +
                "Если у вас возникнут вопросы или вам потребуется помощь, пожалуйста, не стесняйтесь обращаться к нашей службе поддержки.\n\n" +
                "С наилучшими пожеланиями,\n" +
                "Команда " + "Your Drop" + "\n" +
                "Телефон: +123456789\n" +
                "Email: info@exampledanceschool.com";

        sendEmail(client.getEmail(), subject, text);
    }

}
