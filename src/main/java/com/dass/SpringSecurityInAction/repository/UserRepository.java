package com.dass.SpringSecurityInAction.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dass.SpringSecurityInAction.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findUserByUsername(String u);
}
