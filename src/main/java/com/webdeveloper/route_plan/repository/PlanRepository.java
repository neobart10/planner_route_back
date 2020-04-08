package com.webdeveloper.route_plan.repository;

import org.springframework.data.repository.CrudRepository;

import com.webdeveloper.route_plan.domain.Plan;

public interface PlanRepository extends CrudRepository<Plan, Integer>{

}
