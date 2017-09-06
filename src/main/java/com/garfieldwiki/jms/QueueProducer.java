package com.garfieldwiki.jms;

import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class QueueProducer {

	private static final Logger LOGGER = Logger.getLogger(QueueProducer.class.getName());

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	@Qualifier("queueDestination")
	private Queue queue;

	public void sendMessage() {
		this.jmsTemplate.send(this.queue, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				String msg = "Hello, I am Garfield.";
				LOGGER.info("Send message to garfield queue: " + msg);
				return session.createTextMessage(msg);
			}
		});
	}

}
