package com.relay2.email;

import java.net.URL;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.UrlResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SimpleOrderManager4 implements OrderManager {
	
	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@Override
	public void placeOrder(final Order order) {
		
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
			helper.setFrom("xxx@zzz.com");
			helper.setTo(order.getMail());
			helper.setText("Dear " + order.getFirstName()+" " + order.getLastName() + ", thank you order"
					+ ", you order number is: " + order.getOrder() + "<html><body><img src='cid:abc'></body></html>", true);
			
			URL stream = this.getClass().getResource("/Networking5.png");
			helper.addInline("abc", new UrlResource(stream));
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		mailSender.send(message);
	}

}
