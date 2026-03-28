package com.thalysdev.user_registration_system.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RabbitMQConfig {

	@Value("${broker.exchange.user}")
	private String userExchange;

	@Bean
	public TopicExchange orderExchange() {

		return new TopicExchange(userExchange, true, false);
	}

	@Bean
	public Jackson2JsonMessageConverter messageConverter() {

		ObjectMapper objectMapper = new ObjectMapper();
		return new Jackson2JsonMessageConverter(objectMapper);
	}
}
