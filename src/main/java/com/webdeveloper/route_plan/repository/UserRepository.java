package com.webdeveloper.route_plan.repository;

import org.springframework.data.repository.CrudRepository;

import com.webdeveloper.route_plan.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
  User findByUsername(String username);
}
