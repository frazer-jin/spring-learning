package com.relay2.email;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SimpleOrderManager implements OrderManager {
	
	private MailSender mailSender;
	
	private SimpleMailMessage simpleMailMessage;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	@Override
	public void placeOrder(Order order) {

		SimpleMailMessage msg = new SimpleMailMessage(simpleMailMessage);
		
		msg.setTo(order.getMail());
		msg.setText("Dear " + order.getFirstName()+" " + order.getLastName() + ", thank you order"
				+ ", you order number is: " + order.getOrder());
		
		mailSender.send(msg);
	}

}
