package com.example.PaymentGateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String name, String course, double amount){
        SimpleMailMessage message = new SimpleMailMessage();//client
        message.setTo(toEmail);
        message.setSubject("Payment successfull -"+ course);
        message.setText("Hi "+ name + "Thank you for enrolling in "+ course);

        mailSender.send(message);

    }
}
