package org.springframework.samples.petclinic.rabbitmq;

import com.azure.spring.messaging.servicebus.implementation.core.annotation.ServiceBusListener;
import com.azure.messaging.servicebus.ServiceBusErrorSource;
import com.azure.messaging.servicebus.ServiceBusException;
import com.azure.spring.messaging.implementation.annotation.EnableAzureMessaging;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@EnableAzureMessaging
@Service
public class SecondListener {

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

	private void handleMessage(String detailMessage) throws Exception {
		if(!StringUtils.hasLength(detailMessage)){
			throw new Exception("message is empty");
		}else{
			System.out.print(detailMessage);
		}
	}
}
