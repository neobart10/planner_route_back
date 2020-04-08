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
	
	private Double startLat;
	
	private Double startLng;
	
	private Double targetLat;
	
	private Double targetLng;
	
	private Integer stop;
	
	private Integer state;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getStartLat() {
		return startLat;
	}
	public void setStartLat(Double startLat) {
		this.startLat = startLat;
	}
	public Double getStartLng() {
		return startLng;
	}
	public void setStartLng(Double startLng) {
		this.startLng = startLng;
	}
	public Double getTargetLat() {
		return targetLat;
	}
	public void setTargetLat(Double targetLat) {
		this.targetLat = targetLat;
	}
	public Double getTargetLng() {
		return targetLng;
	}
	public void setTargetLng(Double targetLng) {
		this.targetLng = targetLng;
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
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
}
