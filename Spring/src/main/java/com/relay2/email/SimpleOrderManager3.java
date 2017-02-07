package com.relay2.email;

import java.net.URL;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.UrlResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SimpleOrderManager3 implements OrderManager {
	
	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@Override
	public void placeOrder(final Order order) {
		
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
			helper.setFrom("xxx@yyy.com");
			helper.setTo(order.getMail());
			helper.setText("Dear " + order.getFirstName()+" " + order.getLastName() + ", thank you order"
					+ ", you order number is: " + order.getOrder());
			
			URL stream = this.getClass().getResource("/Networking5.png");
			helper.addAttachment("netowrk.png", new UrlResource(stream));
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		mailSender.send(message);
	}

}
