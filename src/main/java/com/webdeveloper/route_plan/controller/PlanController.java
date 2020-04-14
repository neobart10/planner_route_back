package com.webdeveloper.route_plan.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webdeveloper.route_plan.domain.Plan;
import com.webdeveloper.route_plan.repository.PlanRepository;

@RestController
@RequestMapping("plan")
public class PlanController {

	@Autowired
	private PlanRepository planRepository;

	@RequestMapping(method = RequestMethod.GET, value = "")
	Iterable<Plan> getAll() {
		return this.planRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	Plan getById(@PathVariable("id") int id, HttpServletResponse response) throws IOException {
		Optional<Plan> plan = this.planRepository.findById(id);

		if (plan.isPresent()) {
			return plan.get();
		} else {
			response.sendError(HttpStatus.NO_CONTENT.value(), "User not exist");
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "")
	Plan save(@RequestBody Plan plan) {
		return this.planRepository.save(plan);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	Plan update(@RequestBody Plan plan, @PathVariable("id") int id, HttpServletResponse response) throws IOException {
		Optional<Plan> optional = this.planRepository.findById(id);
		if (optional.isPresent()) {
			Plan planUpdate = optional.get();
			planUpdate.setDescription(plan.getDescription());
			planUpdate.setLng(plan.getLng());
			planUpdate.setLat(plan.getLat());
			planUpdate.setKm(plan.getKm());
			planUpdate.setState(plan.getState());
			planUpdate.setStop(plan.getStop());
			return this.planRepository.save(planUpdate);
		} else {
			response.sendError(HttpStatus.NO_CONTENT.value(), "Plan not exist");
			return null;
		}
	}

}
