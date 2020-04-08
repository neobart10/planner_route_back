package com.webdeveloper.route_plan.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROUTES")
public class Route {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
	private User user;
	
	private String description;
	
	private String startDescription;
	
	private String targetDescription;
	
	private Double startLat;
	
	private Double startLng;
	
	private Double targetLat;
	
	private Double targetLng;
	
	private Integer hourStop;
	
	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<Plan> plans = new LinkedList<Plan>();

	public Integer getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public String getDescription() {
		return description;
	}

	public String getStartDescription() {
		return startDescription;
	}

	public String getTargetDescription() {
		return targetDescription;
	}

	public Double getStartLat() {
		return startLat;
	}

	public Double getStartLng() {
		return startLng;
	}

	public Double getTargetLat() {
		return targetLat;
	}

	public Double getTargetLng() {
		return targetLng;
	}

	public Integer getHourStop() {
		return hourStop;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStartDescription(String startDescription) {
		this.startDescription = startDescription;
	}

	public void setTargetDescription(String targetDescription) {
		this.targetDescription = targetDescription;
	}

	public void setStartLat(Double startLat) {
		this.startLat = startLat;
	}

	public void setStartLng(Double startLng) {
		this.startLng = startLng;
	}

	public void setTargetLat(Double targetLat) {
		this.targetLat = targetLat;
	}

	public void setTargetLng(Double targetLng) {
		this.targetLng = targetLng;
	}

	public void setHourStop(Integer hourStop) {
		this.hourStop = hourStop;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}
	
	
}
