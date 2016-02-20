package com.zet.framework.service;


import java.util.Properties;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.zet.framework.util.SendMailAPI;

public class JMSListener  extends JMSBase implements MessageListener, ExceptionListener,InitializingBean,DisposableBean {
	private final static Log LOG = LogFactory.getLog(JMSListener.class);

	private Properties props;
	
	private String emailPassword;
	
	private String emailFrom;
	
	private long initDelay;
	
	private String jmsClientId="account-activemq";

	private Connection conn;
	private String jmsJndiName = "ConnectionFactory";
	private String jmsNameJNDI;

	private javax.naming.Context ctx;
	private Session session = null;

	private ScheduledThreadPoolExecutor scheduledExecutor = new ScheduledThreadPoolExecutor(5);

	public void afterPropertiesSet() throws Exception {
		
		scheduledExecutor.schedule(new Runnable() {
			public void run() {
				try {
					ctx = new InitialContext(props);
					ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup(jmsJndiName);
					LOG.info("connecting to " + props.getProperty("java.naming.provider.url"));
					conn = connectionFactory.createConnection();
					conn.setClientID(jmsClientId);
					conn.start();
					conn.setExceptionListener(JMSListener.this);
					session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
					Destination destination = (Destination) ctx.lookup(jmsNameJNDI);
					session.createConsumer(destination).setMessageListener(JMSListener.this);
					LOG.info("JMS connection " + conn + " Session " + session + " destination " + destination);

				} catch (Exception e) {
					try {
						session.close();
						LOG.error("Cannot create consumer",e);
					} catch (JMSException e1) {
						LOG.error("Cannot close session at JMSListener", e1);
					}
				}
			}
		}, initDelay, TimeUnit.SECONDS);
	}

	public void destroy() throws JMSException, NamingException{
		if (session != null) {
			session.close();
		}
		if (conn != null) {
			conn.stop();
			conn.close();
		}
		if (ctx != null) {
			ctx.close();
		}

		scheduledExecutor.shutdown();
		
	}

	public void onException(JMSException e) {
		LOG.error("JMS Error:" + e.getMessage(), e);
	}

	public void onMessage(Message msg) {
		try {
			MapMessage mapMessage = (MapMessage) msg;
			String to = mapMessage.getString(TO);
			String subject = mapMessage.getString(SUBJECT);
			String content = mapMessage.getString(CONTENT);
			SendMailAPI.sendMail(emailFrom, emailPassword, emailFrom, new String[]{to}, subject, content);
			
		} catch (Exception ex) {
			LOG.error("Error onMessage-JMSListener",ex);
		}
	}
	
	
	public void setProps(Properties props) {
		this.props = props;
	}

	public void setInitDelay(long initDelay) {
		this.initDelay = initDelay;
	}

	public void setJmsClientId(String jmsClientId) {
		this.jmsClientId = jmsClientId;
	}

	public void setScheduledExecutor(ScheduledThreadPoolExecutor scheduledExecutor) {
		this.scheduledExecutor = scheduledExecutor;
	}

	public void setJmsNameJNDI(String jmsNameJNDI) {
		this.jmsNameJNDI = jmsNameJNDI;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	
}
