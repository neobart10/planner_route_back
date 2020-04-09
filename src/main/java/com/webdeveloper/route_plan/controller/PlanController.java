package com.webdeveloper.route_plan.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(method=RequestMethod.GET, value="")
	Iterable<Plan> getAll(){
		return this.planRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	Plan getById(@PathVariable("id") int id){
		return this.planRepository.findById(id).get();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="")
	Plan save(@RequestBody Plan plan){
		return this.planRepository.save(plan);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="")
	Plan update(@RequestBody Plan plan, @PathVariable("id") int id){
		Optional<Plan> optional = this.planRepository.findById(id);
		if(optional.isPresent()){
			Plan planUpdate =  optional.get();
			planUpdate.setStartLat(plan.getStartLat());
			planUpdate.setStartLng(plan.getStartLng());
			planUpdate.setState(plan.getState());
			planUpdate.setStop(plan.getStop());
			planUpdate.setTargetLat(plan.getTargetLat());
			planUpdate.setTargetLng(plan.getTargetLng());
			return this.planRepository.save(planUpdate);
		}
		return null;
	}
	

}
