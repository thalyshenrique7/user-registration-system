package com.thalysdev.user_registration_system.adapter;

import org.springframework.stereotype.Component;

import com.thalysdev.user_registration_system.domain.model.User;
import com.thalysdev.user_registration_system.dto.UserDTO;

@Component
public class UserAdapter {

	public User adaptToEntity(UserDTO userDTO) {

		User entity = new User();
		entity.setId(userDTO.getId());
		entity.setName(userDTO.getName());

		return entity;
	}
}
