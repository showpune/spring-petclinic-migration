package org.springframework.samples.petclinic.rabbitmq;

import org.apache.catalina.util.StringUtil;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener2 {

	/**
	 * Assigns a Consumer to receive the messages whenever there is one.
	 * @param message
	 */
	@RabbitListener(queues = "queue2")
	public void receiveMessage(FlareMessage message) {
		try{
			String detailMessage = message.getMessage();
			handleMessage(detailMessage);		
		}catch(Exception e){
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}

	private void handleMessage(String detailMessage) {
		if(StringUtil.isEmpty(detailMessage)){
			throw new Exception("message is empty");
		}
	}
}
