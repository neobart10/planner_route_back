package com.webdeveloper.route_plan.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String username;
	
	private String pass;
	
	private Integer  typeVehicle;
	
	private Integer gallonsVehicle;
	
	private Double gallonsKm;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(Integer typeVehicle) {
		this.typeVehicle = typeVehicle;
	}

	public Integer getGallonsVehicle() {
		return gallonsVehicle;
	}

	public void setGallonsVehicle(Integer gallonsVehicle) {
		this.gallonsVehicle = gallonsVehicle;
	}

	public Double getGallonsKm() {
		return gallonsKm;
	}

	public void setGallonsKm(Double gallonsKm) {
		this.gallonsKm = gallonsKm;
	}
	
	

}
