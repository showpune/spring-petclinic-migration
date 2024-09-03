package org.springframework.samples.petclinic.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/sendMessage")
	public String sendMessage() {
		String message = "Sample message using amqp template";
		FlareMessage flareMessage = new FlareMessage();
		flareMessage.setMessage(message);
		amqpTemplate.convertAndSend("queue1", "", message);
		return message;
	}

	@GetMapping("/sendMessage2")
	public String sendMessage2() {
		String message = "Sample message2 using amqp template";
		FlareMessage flareMessage = new FlareMessage();
		flareMessage.setMessage(message);
		amqpTemplate.convertAndSend("queue2", "", flareMessage);
		return message;
	}

}
