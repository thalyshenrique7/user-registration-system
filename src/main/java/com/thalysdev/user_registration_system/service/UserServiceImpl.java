package com.thalysdev.user_registration_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thalysdev.user_registration_system.adapter.UserAdapter;
import com.thalysdev.user_registration_system.domain.model.User;
import com.thalysdev.user_registration_system.domain.repository.UserRepository;
import com.thalysdev.user_registration_system.dto.UserDTO;
import com.thalysdev.user_registration_system.infrastructure.messaging.producer.UserProducer;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserAdapter adapt;

	@Autowired
	private UserProducer producer;

	@Override
	public void create(UserDTO userDTO) {

		User user = this.adapt.adaptToEntity(userDTO);

		try {

			this.repository.save(user);

		} catch (Exception e) {
			throw new RuntimeException("An error has occurred while trying to create the user.");
		}

		this.producer.publishUserCreatedEvent(user);
	}

}
