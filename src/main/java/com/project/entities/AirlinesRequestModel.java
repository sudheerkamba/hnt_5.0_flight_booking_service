package com.project.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class AirlinesRequestModel {
	private String fromPlace;
	private String toPlace;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", shape = Shape.STRING)
	private LocalDateTime travelDate;
	public AirlinesRequestModel(String fromPlace, String toPlace, LocalDateTime travelDate) {
		super();
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.travelDate = travelDate;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public LocalDateTime getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDateTime travelDate) {
		this.travelDate = travelDate;
	}
	public AirlinesRequestModel() {
		// TODO Auto-generated constructor stub
	}
}
