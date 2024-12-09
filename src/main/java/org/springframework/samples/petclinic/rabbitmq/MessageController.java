package org.springframework.samples.petclinic.rabbitmq;

import com.azure.spring.messaging.servicebus.core.ServiceBusTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
/**
 * Spring controller exposes api for Home controller.
 */
@RestController
public class MessageController {

	@Autowired
	private final ServiceBusTemplate serviceBusTemplate;

	public MessageController(ServiceBusTemplate serviceBusTemplate) {
		this.serviceBusTemplate = serviceBusTemplate;
	}

	@Value("${rabitMq.dcs.queue.name}")
    private String DCSQueue;

	@GetMapping("/sendMessage")
	public String sendMessage() {
		String preparedString = "Sample message using amqp template";
		FlareMessage flareObject = new FlareMessage();
		flareObject.setMessage(preparedString);
		Message<FlareMessage> message = MessageBuilder.withPayload(flareObject)
                .setHeader("customHeader", "headerValue")
                .setHeader("contentType", "application/json")
                .build();
		serviceBusTemplate.send(DCSQueue, message);
		return preparedString;
	}

	@GetMapping("/sendMessage2")
	public String sendMessage2() {
		String preparedString = "Sample message2 using amqp template";
		FlareMessage flareObject = new FlareMessage();
		flareObject.setMessage(preparedString);
		//TODO: Need manual change. Azure Service Bus with Spring Messaging doesn't support exchange, routing key, and queue definition in the same way as RabbitMQ. Please refer to the Azure Service Bus documentation to directly send messages to the queue with queue name.
		//amqpTemplate.convertAndSend(DCSQueue, "", flareObject);
		Message<FlareMessage> message = MessageBuilder.withPayload(flareObject)
                .setHeader("customHeader", "headerValue")
                .setHeader("contentType", "application/json")
                .build();
		serviceBusTemplate.send(DCSQueue, message);
		return preparedString;
	}

}
