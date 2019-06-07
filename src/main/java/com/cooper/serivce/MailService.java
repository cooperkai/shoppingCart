package com.cooper.serivce;

import java.io.UnsupportedEncodingException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private TemplateEngine templateEngine;
	
	private final String FROM = "ba104g5@gmail.com";
	
	// send email
	public void sendMail(String to, String subject, String text, String template) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		helper.setFrom(FROM);
		helper.setTo(to);
		helper.setSubject(subject);
		
		Context context = new Context();
		context.setVariable("hi", "您好");
		context.setVariable("title", "歡迎登入Shopping Cart");
		context.setVariable("content", text);
		String emailContent = templateEngine.process(template, context);
		helper.setText(emailContent, true);
        this.javaMailSender.send(mimeMessage);
	}
	
	// send email with attachment
	public void sendMailWithAttachment(String to, String subject, String text, String filePath) throws MessagingException, UnsupportedEncodingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		helper.setFrom(FROM);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(text);
		Multipart multipart = new MimeMultipart();
		multipart = setFile(filePath, multipart);
		mimeMessage.setContent(multipart);
        this.javaMailSender.send(mimeMessage);
	}

	// handle attachment
	public Multipart setFile(String filePath, Multipart multipart) throws MessagingException {
		BodyPart messageBodyPart = new MimeBodyPart();
		DataSource source = new FileDataSource(filePath);
		messageBodyPart.setDataHandler(new DataHandler(source));
		// solve chinese file name(if > 60size)
		messageBodyPart.setFileName(source.getName());
		multipart.addBodyPart(messageBodyPart);
		return multipart;
	}
}
