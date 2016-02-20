package com.zet.framework.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Send gmail api
 * @author manle
 *
 */
public class SendMailAPI {
	
	private static final String MAIL_SMTP_AUTH_KEY = "mail.smtp.auth";
	private static final String MAIL_SMTP_AUTH_VALUE = "true";
	
	private static final String MAIL_SMTP_STARTTLS_ENABLE_KEY = "mail.smtp.starttls.enable";
	private static final String MAIL_SMTP_STARTTLS_ENABLE_VALUE = "true";
	
	private static final String MAIL_SMTP_HOST_KEY = "mail.smtp.host";
	private static final String MAIL_SMTP_HOST_VALUE = "smtp.gmail.com";
	
	private static final String MAIL_SMTP_PORT_KEY = "mail.smtp.port";
	private static final String MAIL_SMTP_PORT_VALUE = "587";
	
	private final static Log LOG = LogFactory.getLog(SendMailAPI.class);
	
	public static Boolean sendMail(final String username,final String password,final String from,final String[] to,final String subject,final String content){
		Properties props = new Properties();
		props.put(MAIL_SMTP_AUTH_KEY, MAIL_SMTP_AUTH_VALUE);
		props.put(MAIL_SMTP_STARTTLS_ENABLE_KEY, MAIL_SMTP_STARTTLS_ENABLE_VALUE);
		props.put(MAIL_SMTP_HOST_KEY, MAIL_SMTP_HOST_VALUE);
		props.put(MAIL_SMTP_PORT_KEY,MAIL_SMTP_PORT_VALUE);
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		String currentMail = "";
		try {
			for(int i=0;i<to.length;i++){
				currentMail = to[i];
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to[i]));
				message.setSubject(subject, "UTF-8");
				message.setText(content, "UTF-8");
				message.setHeader("Content-Type", "text/html; charset=UTF-8");
				Transport.send(message);
				LOG.info("Sended email to "+to[i]);
			}
			return true;
		} catch (MessagingException e) {
			LOG.error("Cannot send email to "+currentMail,e);
			return false;
		}
	}
	
}
