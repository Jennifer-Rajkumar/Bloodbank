package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailService {
	
	public Session Authentication() {
		final String username = "mymailid";
		final String password = "mypassword";
		
		String host = "smtp.gmail.com";
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.user", username);
	    props.put("mail.smtp.password", password);
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.port", "587"); 
	    props.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		return session;
		
	}
	
	public void Notification(List<String> toEmail, String bg) {
		
		String fromEmail = "jenn18cs030@rmkcet.ac.in";
		
		Session session = Authentication();
		
		//Start our mail message
		MimeMessage msg = new MimeMessage(session);
		try {
			
			msg.setFrom(new InternetAddress(fromEmail));
			
			for(int i=0;i<toEmail.size();i++) {
			    msg.addRecipient(Message.RecipientType.CC, new InternetAddress(toEmail.get(i)));
			}
			
			msg.setSubject("Urgent!");
			
			Multipart emailContent = new MimeMultipart();
			
			//Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("Blood group " + bg + " required");
			
			//Attach body parts
			emailContent.addBodyPart(textBodyPart);
			
			//Attach multipart to message
			msg.setContent(emailContent);
			
			Transport.send(msg);
			System.out.println("Sent message");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
