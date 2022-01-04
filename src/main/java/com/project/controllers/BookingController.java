package com.project.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.project.entities.AirlinesModel;
import com.project.entities.AirlinesRequestModel;
import com.project.entities.TicketModel;
import com.project.exceptions.FlightTicketException;
import com.project.services.BookingService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0/flight")
public class BookingController {
	
	@Autowired
	BookingService service;

	@PostMapping("/booking/{id}")
	public TicketModel bookTicket(@RequestBody TicketModel model,@PathVariable Long id) {
		
		return service.bookTicket(model);
	}
	@PutMapping("/cancel")
	public TicketModel cancelTicket(@RequestBody TicketModel model) {
		
		return service.cancelTicket(model);
	}
	@GetMapping("/tickets")
	public List<TicketModel> getAllTicketDetails() {
		
		return service.getAllTicketDetails();
	}
	@GetMapping("/ticket/{id}")
	public List<TicketModel> getTicketDetailsById(@PathVariable Long id) throws FlightTicketException {
		System.out.println("tick Id : "+id);
		return service.getTicketDetailsById(id);
	}
	@GetMapping("/tickets/{emailId}")
	public List<TicketModel> getTicketDetailsByEmailId(@PathVariable String emailId) throws FlightTicketException {
		System.out.println("mail Id : "+emailId);
		return service.getTicketDetailsByEmailId(emailId);
	}
	@PostMapping("/search")
	public List<AirlinesModel> searchFlight(@RequestBody AirlinesRequestModel post) {
		return service.searchFlight(post);
		
	}
	
	
	
}
