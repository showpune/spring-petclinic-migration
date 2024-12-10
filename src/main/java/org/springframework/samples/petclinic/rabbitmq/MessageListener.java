package org.springframework.samples.petclinic.rabbitmq;

import com.azure.spring.messaging.servicebus.implementation.core.annotation.ServiceBusListener;
import com.azure.messaging.servicebus.ServiceBusErrorSource;
import com.azure.messaging.servicebus.ServiceBusException;
import com.azure.spring.messaging.implementation.annotation.EnableAzureMessaging;
import org.springframework.stereotype.Service;

@EnableAzureMessaging
@Service
public class MessageListener {

	/**
	 * Assigns a Consumer to receive the messages whenever there is one.
	 * @param message
	 */
	@ServiceBusListener(destination = "${rabitMq.dcs.queue.name}")
	public void receiveMessage(FlareMessage message) {
		try{
			String detailMessage = message.getMessage();
			handleMessage(detailMessage);
		}catch(Exception e){
			throw new ServiceBusException(e,ServiceBusErrorSource.ABANDON);
		}
	}

	private void handleMessage(String detailMessage) {
		throw new UnsupportedOperationException("Unimplemented method 'handleMessage'");
	}

	@ServiceBusListener(destination = "${rabitMq.dcs.queue.name}")
	public void receiveMessage2(FlareMessage message) {
		if(message == null){
			throw new ServiceBusException(new Exception("message is null"),ServiceBusErrorSource.ABANDON);
		}
		System.out.println("Received Message2:" + message.getMessage());
	}

}
