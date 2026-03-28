package com.thalysdev.user_registration_system.infrastructure.messaging.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.thalysdev.user_registration_system.domain.model.User;
import com.thalysdev.user_registration_system.event.UserCreatedEvent;

@Component
public class UserProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserProducer.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${broker.exchange.user}")
	private String exchange;

	@Value("${broker.routing.user-created}")
	private String routingKey;

	public void publishUserCreatedEvent(User user) {

		Long userId = user.getId();

		LOGGER.info("Publishing event: user.created | exchange={} routingKey={} userId={}", exchange, routingKey,
				userId);

		UserCreatedEvent userCreatedEvent = new UserCreatedEvent();
		userCreatedEvent.setId(userId);
		userCreatedEvent.setName(user.getName());

		this.rabbitTemplate.convertAndSend(exchange, routingKey, userCreatedEvent);

		LOGGER.info("Event published: order.created | userId={}", userId);
	}
}
