package org.springframework.samples.petclinic.rabbitmq;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

	/**
	 * Assigns a Consumer to receive the messages whenever there is one.
	 * @param message
	 */
	@RabbitListener(queues = "${rabitMq.dcs.queue.name}")
	public void receiveMessage(FlareMessage message) {
		try{
			String detailMessage = message.getMessage();
			handleMessage(detailMessage);		
		}catch(Exception e){
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}

	private void handleMessage(String detailMessage) {
		throw new UnsupportedOperationException("Unimplemented method 'handleMessage'");
	}

	@RabbitListener(queues = "${rabitMq.dcs.queue.name}")
	public void receiveMessage2(FlareMessage message) {
		if(message == null){
			throw new AmqpRejectAndDontRequeueException(new Exception("message is null"));
		}
		System.out.println("Received Message2:" + message.getMessage());
	}

}
