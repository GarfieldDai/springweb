package com.garfieldwiki.jms;

import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class QueueConsumer implements MessageListener {

	private static final Logger LOGGER = Logger.getLogger(QueueConsumer.class.getName());

	public void onMessage(Message message) {
		try {
			TextMessage textMsg = (TextMessage) message;
			LOGGER.info("Receive a message from ActiveMQ: " + textMsg.getText());
		} catch (JMSException e) {
			LOGGER.warning(e.getMessage());
		}
	}

}
