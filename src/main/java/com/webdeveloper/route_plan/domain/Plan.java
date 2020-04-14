package com.webdeveloper.route_plan.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PLANS")
public class Plan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "id_route", referencedColumnName = "id")
	private Route route;
	
	private  String description;
	
	private Double lng;
	
	private Double lat;
	
	private Double km;
	
	private Integer stop;
	
	private Integer state;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStop() {
		return stop;
	}
	public void setStop(Integer stop) {
		this.stop = stop;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	/*public Route getRoute() {
		return route;
	}*/
	public void setRoute(Route route) {
		this.route = route;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getKm() {
		return km;
	}
	public void setKm(Double km) {
		this.km = km;
	}
	
}
