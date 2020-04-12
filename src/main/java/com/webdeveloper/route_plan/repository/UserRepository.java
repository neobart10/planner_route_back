package com.webdeveloper.route_plan.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.webdeveloper.route_plan.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
  Optional<User> findByUsername(String username);
}
