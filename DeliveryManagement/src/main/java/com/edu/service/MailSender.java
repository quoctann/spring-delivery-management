/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.service;

import org.springframework.mail.javamail.JavaMailSender;

/**
 *
 * @author beanp
 */
public interface MailSender {
    JavaMailSender getMailSender();
    void sendMail(String from, String to, String subject, String content);
}
