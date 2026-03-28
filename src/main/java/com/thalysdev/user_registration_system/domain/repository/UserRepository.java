package com.thalysdev.user_registration_system.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thalysdev.user_registration_system.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
