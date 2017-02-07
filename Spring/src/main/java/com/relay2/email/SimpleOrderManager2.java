package com.relay2.email;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class SimpleOrderManager2 implements OrderManager {
	
	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@Override
	public void placeOrder(final Order order) {
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
//				mimeMessage.setReplyTo(new Address[]{
//						new InternetAddress(order.getMail())
//				});
				mimeMessage.setRecipient(RecipientType.TO, new InternetAddress(order.getMail()));
				mimeMessage.setFrom(new InternetAddress("minfei.jin@xxx.com"));
				mimeMessage.setText("Dear " + order.getFirstName()+" " + order.getLastName() + ", thank you order"
						+ ", you order number is: " + order.getOrder());
			}
		};
		
		mailSender.send(preparator);
	}

}
