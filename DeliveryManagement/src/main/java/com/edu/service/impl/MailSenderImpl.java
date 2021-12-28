///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.edu.service.impl;
//
//import com.edu.service.MailSender;
//import java.util.Properties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.mail.SimpleMailMessage;
//
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author beanp
// */
//@Service
//public class MailSenderImpl implements MailSender {
//
//    @Override
//    public JavaMailSender getMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(6060);
//        mailSender.setUsername("testmailservicejavax@gmail.com");
//        mailSender.setPassword("24102000Aa");
//        
//        Properties javaMailProps = new Properties();
//        javaMailProps.put("mail.smtp.starttls.enable", "true");
//        javaMailProps.put("mail.smtp.auth", "true");
//        javaMailProps.put("mail.transport.protocol", "smtp");
//        javaMailProps.put("mail.debug", "true");
//        
//        mailSender.setJavaMailProperties(javaMailProps);
//        
//        return mailSender;
//    }
//    
//    @Override
//    public void sendMail(String from, String to, String subject, String content) {
//      SimpleMailMessage mes = new SimpleMailMessage();
//      mes.setFrom(from);
//      mes.setTo(to);
//      mes.setSubject(subject);
//      mes.setText(content);
//      
//      this.getMailSender().send(mes);
//    }
//    
//              
//    
//}
