package org.springframework.samples.petclinic.rabbitmq;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SecondListener {

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

	private void handleMessage(String detailMessage) throws Exception {
		if(!StringUtils.hasLength(detailMessage)){
			throw new Exception("message is empty");
		}else{
			System.out.print(detailMessage);
		}
	}
}
