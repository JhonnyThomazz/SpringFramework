package com.projetosSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetosSpring.entity.User;

public interface UserRepository extends JpaRepository <User, Long> {

}
