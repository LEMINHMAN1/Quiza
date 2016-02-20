package com.zet.framework.service;

import java.util.Properties;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 
 * @author Man.Le
 */

public class JMSSending extends JMSBase implements ExceptionListener,InitializingBean,DisposableBean{
	
	private final static Log LOG = LogFactory.getLog(JMSSending.class);
	
	private ScheduledThreadPoolExecutor scheduledExecutor;

	private Properties props;

	private Destination destination;
	
	private String jmsJndiName = "ConnectionFactory";
	
	private javax.naming.Context ctx;
	
	private String jmsNameJNDI;
	
	private MessageProducer producer = null;
	
	private Connection conn=null;
	
	private Session session = null;
	
	public void sendMailMessage(final String to,final String subject,final String content){
		 try{
			 	MapMessage mapMessage = session.createMapMessage();
		        mapMessage.setString(SUBJECT, subject);
		        mapMessage.setString(CONTENT, content);
		        mapMessage.setString(TO, to);
		        producer.send(destination, mapMessage);	 
		        session.commit();
		 }catch(JMSException ex){
			 LOG.error("Cannot send mapMessage to activemq",ex);
			 try {
				session.rollback();
			} catch (JMSException e) {
				LOG.error("Session cannot rollback",e);
			}
		 }
   }
	 
	public void onException(JMSException exception) {
		LOG.error("Error when to connect JMS \n"+exception);
	}

	public void afterPropertiesSet() throws Exception {
			ctx = new InitialContext(props);
	        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup(jmsJndiName);
	        conn = connectionFactory.createConnection();
	        conn.start();
	        conn.setExceptionListener(JMSSending.this);
	        session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
	        destination = (Destination) ctx.lookup(jmsNameJNDI);
	        
	        producer = session.createProducer(destination);
	        
	}

	public void destroy() throws Exception {
		if (session!=null){
            session.close();
        }
        if (conn!=null){
            conn.close();
        }
        
        scheduledExecutor.shutdown();
		
	}
	
	public void setProps(Properties props) {
		this.props = props;
	}
	public void setJmsNameJNDI(String jmsNameJNDI) {
		this.jmsNameJNDI = jmsNameJNDI;
	}

}
