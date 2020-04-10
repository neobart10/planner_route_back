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
	Route getById(@PathVariable("id") int id, HttpServletResponse response) throws IOException{
		Optional<Route> route = this.routeRepository.findById(id); 
		
		if (route.isPresent()) {
			return route.get();	
		} else {
			response.sendError(HttpStatus.NO_CONTENT.value(), "User not exist");
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/byUser/{idUser}")
	Iterable<Route> getByUser(@PathVariable("idUser") int idUser, HttpServletResponse response) throws IOException{
		Optional<User> user = this.userRepository.findById(idUser);
		if(user.isPresent()) {
			return this.routeRepository.findByUser(user.get());	
		}else {
			response.sendError(HttpStatus.NO_CONTENT.value(), "User not exist");
			return null;
		}
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="")
	Route save(@RequestBody Route route){
		return this.routeRepository.save(route);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
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
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	boolean delete(@PathVariable("id") int id){
		Optional<Route> optional = this.routeRepository.findById(id);
		if(optional.isPresent()) {
		  this.routeRepository.deleteById(id);
		  return true;
		} else {
			return false;
		}
	}
}
