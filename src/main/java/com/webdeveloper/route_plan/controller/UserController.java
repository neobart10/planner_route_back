package com.webdeveloper.route_plan.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.webdeveloper.route_plan.domain.User;
import com.webdeveloper.route_plan.repository.UserRepository;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="")
	Iterable<User> getAllUser(){
		return this.userRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	User getUserById(@PathVariable("id") int id){
		return this.userRepository.findById(id).get();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="")
	User save(@RequestBody User user){
		return this.userRepository.save(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	User update(@RequestBody User user, @PathVariable("id") int id){
		Optional<User> optional = this.userRepository.findById(id);
		if(optional.isPresent()){
			User userUpdate =  optional.get();
			userUpdate.setGallonsKm(user.getGallonsKm());
			userUpdate.setGallonsVehicle(user.getGallonsVehicle());
			userUpdate.setPass(user.getPass());
			userUpdate.setTypeVehicle(user.getTypeVehicle());
			return this.userRepository.save(userUpdate);
		}
		return null;
		
	}

}
