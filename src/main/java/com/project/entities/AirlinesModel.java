package com.project.entities;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity(name = "airlines")
public class AirlinesModel {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flightNo;
	private String airline;
	private Integer businessClassSeats;
	private Integer nonBusinessClassSeats;
	private Double ticketCost;

	public AirlinesModel(Integer flightNo, String airline, String fromPlace, String toPlace, LocalDateTime startTime,
			LocalDateTime endTime, String instrumentType, String mealsType, String is_blocked,Integer businessClassSeats,
			Integer nonBusinessClassSeats,Double ticketCost) {
		this.flightNo = flightNo;
		this.airline = airline;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.startTime = startTime;
		this.endTime = endTime;
		this.instrumentType = instrumentType;
		this.mealsType = mealsType;
		this.businessClassSeats=businessClassSeats;
		this.nonBusinessClassSeats=nonBusinessClassSeats;
		this.ticketCost=ticketCost;
		this.is_blocked = is_blocked;
	}
	public AirlinesModel( String airline, String fromPlace, String toPlace, LocalDateTime startTime,
			LocalDateTime endTime, String instrumentType, String mealsType, String is_blocked,Integer businessClassSeats,
			Integer nonBusinessClassSeats,Double ticketCost) {
		
		this.airline = airline;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.startTime = startTime;
		this.endTime = endTime;
		this.instrumentType = instrumentType;
		this.mealsType = mealsType;
		this.businessClassSeats=businessClassSeats;
		this.nonBusinessClassSeats=nonBusinessClassSeats;
		this.ticketCost=ticketCost;
		this.is_blocked = is_blocked;
	}

	private String fromPlace;
	private String toPlace;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", shape = Shape.STRING)
	private LocalDateTime startTime;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", shape = Shape.STRING)
	private LocalDateTime endTime;
	private String instrumentType;
	private String mealsType;
	@Column(columnDefinition = "varchar(255) default 'N'")
	private String is_blocked;

	public Integer getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(Integer flightNo) {
		this.flightNo = flightNo;
	}

	public AirlinesModel() {

		// TODO Auto-generated constructor stub
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
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

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(String instrumentType) {
		this.instrumentType = instrumentType;
	}

	public String getMealsType() {
		return mealsType;
	}

	public void setMealsType(String mealsType) {
		this.mealsType = mealsType;
	}

	public String getIs_blocked() {
		return is_blocked;
	}

	public void setIs_blocked(String is_blocked) {
		this.is_blocked = is_blocked;
	}

	public Integer getBusinessClassSeats() {
		return businessClassSeats;
	}

	public void setBusinessClassSeats(Integer businessClassSeats) {
		this.businessClassSeats = businessClassSeats;
	}

	public Integer getNonBusinessClassSeats() {
		return nonBusinessClassSeats;
	}

	public void setNonBusinessClassSeats(Integer nonBusinessClassSeats) {
		this.nonBusinessClassSeats = nonBusinessClassSeats;
	}

	public Double getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(Double ticketCost) {
		this.ticketCost = ticketCost;
	}

}
