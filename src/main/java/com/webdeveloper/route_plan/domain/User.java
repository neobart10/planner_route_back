package com.webdeveloper.route_plan.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique=true)
	private String username;
	
	private String pass;
	
	private Integer  typeVehicle;
	
	private Integer gallonsVehicle;
	
	private Double gallonsKm;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Route> routes = new LinkedList<Route>();
	
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

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}
}
