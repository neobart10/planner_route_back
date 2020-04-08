package com.webdeveloper.route_plan.repository;

import org.springframework.data.repository.CrudRepository;

import com.webdeveloper.route_plan.domain.Route;
import com.webdeveloper.route_plan.domain.User;

public interface RouteRepository extends CrudRepository<Route, Integer> {
  Iterable<Route> findByUser(User user);
}
	