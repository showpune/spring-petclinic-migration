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
	@RabbitListener(queues = "queue.excur")
	public void receiveMessage(String message) {
		System.out.println("Received Message:" + message);
		if(message == null){
			throw new AmqpRejectAndDontRequeueException("message is null");
		}
	}

	@RabbitListener(queues = "queue.excur")
	public void receiveMessage2(String message) {
		System.out.println("Received Message:" + message);
		if(message == null){
			throw new AmqpRejectAndDontRequeueException("message is null");
		}
	}

}
