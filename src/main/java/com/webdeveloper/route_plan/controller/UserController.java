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

import com.webdeveloper.route_plan.domain.User;
import com.webdeveloper.route_plan.repository.UserRepository;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="")
	Iterable<User> getAll(){
		return this.userRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	User getById(@PathVariable("id") int id, HttpServletResponse response) throws IOException{
		Optional<User> user = this.userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();	
		}else {
			response.sendError(HttpStatus.NO_CONTENT.value(), "User not exist");
			return null	;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="")
	User save(@RequestBody User user, HttpServletResponse response) throws IOException{
		Optional<User> userOptional =  this.userRepository.findByUsername(user.getUsername());
		if(!userOptional.isPresent()) {
			return this.userRepository.save(user);	
		}else {
			response.sendError(HttpStatus.MULTI_STATUS.value(), "Username already exist");
			return userOptional.get();
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	User update(@RequestBody User user, @PathVariable("id") int id, HttpServletResponse response) throws IOException{
		Optional<User> optional = this.userRepository.findById(id);
		if(optional.isPresent()){
			User userUpdate =  optional.get();
			userUpdate.setGallonsKm(user.getGallonsKm());
			userUpdate.setGallonsVehicle(user.getGallonsVehicle());
			userUpdate.setPass(user.getPass());
			userUpdate.setTypeVehicle(user.getTypeVehicle());
			return this.userRepository.save(userUpdate);
		}else {
			response.sendError(HttpStatus.NO_CONTENT.value(), "User not exist");
			return null;
		}
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	User login(@RequestBody User user, HttpServletResponse response) throws IOException{
		Optional<User> userOptional =  this.userRepository.findByUsername(user.getUsername());
		if(userOptional.isPresent() && userOptional.get().getPass().equals(user.getPass())) {
			response.setStatus(HttpStatus.OK.value());
			return userOptional.get();	
		}else {
			response.sendError(HttpStatus.UNAUTHORIZED.value(), "Username not exist");
			return null;
		}
	}

}
