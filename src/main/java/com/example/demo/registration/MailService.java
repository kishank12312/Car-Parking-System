package com.example.demo.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {

    @Autowired
    public JavaMailSender mailSender;

    public void sendMessage(String text, String to){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@carParkingSystem.com");
        message.setTo(to);
        message.setSubject("Verify Your OTP on your Account with Car Parking System!");
        message.setText(text);
        mailSender.send(message);
    }
}
