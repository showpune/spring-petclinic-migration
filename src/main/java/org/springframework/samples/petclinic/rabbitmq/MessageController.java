package org.springframework.samples.petclinic.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring controller exposes api for Home controller.
 */
@RestController
public class MessageController {

	@Autowired
	private final AmqpTemplate amqpTemplate;

	public MessageController(AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}

	@Value("${rabitMq.dcs.queue.name}")
    private String DCSQueue;

	@GetMapping("/sendMessage")
	public String sendMessage() {
		String preparedString = "Sample message using amqp template";
		FlareMessage flareObject = new FlareMessage();
		flareObject.setMessage(preparedString);
		amqpTemplate.convertAndSend(DCSQueue, "", flareObject);
		return preparedString;
	}

	@GetMapping("/sendMessage2")
	public String sendMessage2() {
		String preparedString = "Sample message2 using amqp template";
		FlareMessage flareObject = new FlareMessage();
		flareObject.setMessage(preparedString);
		amqpTemplate.convertAndSend(DCSQueue, "", flareObject);
		return preparedString;
	}

}
