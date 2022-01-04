package com.project.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity(name="booking_details")

public class TicketModel {
	
	private String flightNo;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "pnrNumber")
	@SequenceGenerator(name="pnrNumber",initialValue = 100001)
	private long pnrNumber;
	private String name;
	private String fromPlace;
	private String toPlace;
	private String status;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS",shape= Shape.STRING)
	private LocalDateTime departure;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS",shape= Shape.STRING)
	private LocalDateTime arrival;
	private String emailId;
	private String mealsType;
	private int seatsCount;

	
	 @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	  
	  @JoinColumn(name="pnrNumber") 
	//@ElementCollection
	private List<Passengers> passengers=new
	  ArrayList<Passengers>();
	 
	public TicketModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public String getMealsType() {
		return mealsType;
	}
	public void setMealsType(String mealsType) {
		this.mealsType = mealsType;
	}
	public LocalDateTime getDeparture() {
		return departure;
	}
	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}
	public LocalDateTime getArrival() {
		return arrival;
	}
	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public TicketModel(String flightNo, String name, String fromPlace, String toPlace, LocalDateTime departure,
			LocalDateTime arrival, String emailId, String mealsType,long pnrNumber, 
			List<Passengers> passengers,
			int seatsCount) {
		super();
		this.flightNo = flightNo;
		this.name = name;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.departure = departure;
		this.arrival = arrival;
		this.emailId = emailId;
		this.mealsType = mealsType;
		this.pnrNumber= pnrNumber;
		this.passengers=passengers;
		this.seatsCount=seatsCount;
	}
	public TicketModel(String flightNo, String name, String fromPlace, String toPlace, LocalDateTime departure,
			LocalDateTime arrival, String emailId, String mealsType,
			List<Passengers> passengers,
			int seatsCount) {
		super();
		this.flightNo = flightNo;
		this.name = name;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.departure = departure;
		this.arrival = arrival;
		this.emailId = emailId;
		this.mealsType = mealsType;
		this.passengers=passengers;
		this.seatsCount=seatsCount;
	}
	public long getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(long pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public int getSeatsCount() {
		return seatsCount;
	}
	public void setSeatsCount(int seatsCount) {
		this.seatsCount = seatsCount;
	}
	
	  public List<Passengers> getPassengers() { return passengers; } public void
	  setPassengers(List<Passengers> passengers) { this.passengers = passengers; }
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
	
	

}
