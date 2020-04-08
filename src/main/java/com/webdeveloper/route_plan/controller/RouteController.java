package com.webdeveloper.route_plan.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webdeveloper.route_plan.domain.Route;
import com.webdeveloper.route_plan.domain.User;
import com.webdeveloper.route_plan.repository.RouteRepository;
import com.webdeveloper.route_plan.repository.UserRepository;

@RestController
@RequestMapping("route")
public class RouteController {

	@Autowired
	private RouteRepository routeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="")
	Iterable<Route> getAll(){
		return this.routeRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	Route getById(@PathVariable("id") int id){
		return this.routeRepository.findById(id).get();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/user/{idUser}")
	Iterable<Route> getByUser(@PathVariable("idUser") int idUser){
		User user = this.userRepository.findById(idUser).get();
		return this.routeRepository.findByUser(user);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="")
	Route save(@RequestBody Route route){
		return this.routeRepository.save(route);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="")
	Route update(@RequestBody Route route, @PathVariable("id") int id){
		Optional<Route> optional = this.routeRepository.findById(id);
		if(optional.isPresent()){
			Route routeUpdate =  optional.get();
			routeUpdate.setDescription(route.getDescription()); 
			routeUpdate.setStartDescription(route.getStartDescription());
			routeUpdate.setTargetDescription(route.getTargetDescription());
			routeUpdate.setStartLat(route.getStartLat());
			routeUpdate.setStartLng(route.getStartLng());
			routeUpdate.setTargetLat(route.getTargetLat());
			routeUpdate.setTargetLng(route.getTargetLng());
			routeUpdate.setHourStop(route.getHourStop());

			return this.routeRepository.save(routeUpdate);
		}
		return null;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="")
	void delete(@PathVariable("id") int id){
		Optional<Route> optional = this.routeRepository.findById(id);
		if(optional.isPresent())
		  this.routeRepository.deleteById(id);
	}
}
