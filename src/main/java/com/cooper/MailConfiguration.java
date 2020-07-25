package com.cooper;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfiguration {
	
	@Value("${mail.smtp.host}")
	private String host;
	@Value("${mail.username}")
	private String userName;
	@Value("${mail.password}")
	private String pwd;
	@Value("${mail.smtp.starttls.enable}")
	private String starttls;
	@Value("${mail.smtp.auth}")
	private String auth;
	@Value("${mail.smtp.port}")
	private String port;
	@Value("${mail.transport.protocol}")
	private String protocol;
	
	@Bean
	public JavaMailSenderImpl javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(host);
		mailSender.setUsername(userName);
		mailSender.setPassword(pwd);
		
		Properties properties = mailSender.getJavaMailProperties();
		properties.put("mail.smtp.starttls.enable", starttls);
		properties.put("mail.smtp.auth", auth);
		properties.put("mail.smtp.port", port);
		properties.put("mail.transport.protocol", protocol);
		return mailSender;
	}
}