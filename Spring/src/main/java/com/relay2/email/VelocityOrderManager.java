package com.relay2.email;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.springframework.core.io.UrlResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class VelocityOrderManager implements OrderManager {
	
	private JavaMailSender mailSender;
	
	private VelocityEngine velocityEngine;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}
	
	@Override
	public void placeOrder(final Order order) {
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
				
				helper.setFrom("test@test.com");
				helper.setTo(order.getMail());
				
				Map<String, Object> model = new HashMap<>();
				model.put("user", order);
				
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "email-template.vm", RuntimeConstants.ENCODING_DEFAULT, model);
				System.out.println(text);
				
				helper.setText(text, true);
			}
		};
		
		mailSender.send(preparator);
	}

}
