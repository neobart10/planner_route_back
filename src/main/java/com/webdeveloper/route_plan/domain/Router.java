package com.webdeveloper.route_plan.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Router {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn( name= "username", referencedColumnName= "name")
    private  User user ;
	
	private String description ;
	
	private String strardescription;
	
	private String targetdescription;
	private Double strarlat;
	private Double strarlog;
	private Double targetlat;
	private Double targetlog;
	private int timeStop;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStrardescription() {
		return strardescription;
	}
	public void setStrardescription(String strardescription) {
		this.strardescription = strardescription;
	}
	public String getTargetdescription() {
		return targetdescription;
	}
	public void setTargetdescription(String targetdescription) {
		this.targetdescription = targetdescription;
	}
	public Double getStrarlat() {
		return strarlat;
	}
	public void setStrarlat(Double strarlat) {
		this.strarlat = strarlat;
	}
	public Double getStrarlog() {
		return strarlog;
	}
	public void setStrarlog(Double strarlog) {
		this.strarlog = strarlog;
	}
	public Double getTargetlat() {
		return targetlat;
	}
	public void setTargetlat(Double targetlat) {
		this.targetlat = targetlat;
	}
	public Double getTargetlog() {
		return targetlog;
	}
	public void setTargetlog(Double targetlog) {
		this.targetlog = targetlog;
	}
	public int getTimeStop() {
		return timeStop;
	}
	public void setTimeStop(int timeStop) {
		this.timeStop = timeStop;
	}
	
}
