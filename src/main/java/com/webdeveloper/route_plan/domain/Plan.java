package com.webdeveloper.route_plan.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	
	private Double startLat;
	
	private Double startLog;
	
	private Double targetLat;
	
	private Double targetLog;
	
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
	public Double getStartLog() {
		return startLog;
	}
	public void setStartLog(Double startLog) {
		this.startLog = startLog;
	}
	public Double getTargetLat() {
		return targetLat;
	}
	public void setTargetLat(Double targetLat) {
		this.targetLat = targetLat;
	}
	public Double getTargetLog() {
		return targetLog;
	}
	public void setTargetLog(Double targetLog) {
		this.targetLog = targetLog;
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
	

}
