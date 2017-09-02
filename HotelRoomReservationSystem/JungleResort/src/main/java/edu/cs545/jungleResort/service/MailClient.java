package edu.cs545.jungleResort.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailClient {

	private JavaMailSender mailSender;

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(String to, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		try {
			javaMailSender.send(message);
		} catch (MailException e) {
			System.err.println("Error sending email !!");
		}

	}
}
