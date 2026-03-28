package com.thalysdev.user_registration_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thalysdev.user_registration_system.dto.UserDTO;
import com.thalysdev.user_registration_system.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/user", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	private final static String USER_CREATED_SUCCESSFULLY_MESSAGE = "User created successfully";

	@Autowired
	private UserService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@Valid @RequestBody UserDTO userDTO) {

		this.service.create(userDTO);

		return USER_CREATED_SUCCESSFULLY_MESSAGE;
	}
}
