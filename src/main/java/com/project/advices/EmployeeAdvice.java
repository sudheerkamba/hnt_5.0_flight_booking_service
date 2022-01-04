package com.project.advices;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.dto.MyErrorResponse;

import com.project.exceptions.FlightTicketException;

@ControllerAdvice
public class EmployeeAdvice {
	@ExceptionHandler(FlightTicketException.class)
public ResponseEntity<MyErrorResponse> handleFlightException(FlightTicketException e){
		MyErrorResponse resp=new MyErrorResponse(e.getMessage(), LocalDateTime.now(), e);
	return new ResponseEntity<MyErrorResponse>(resp,HttpStatus.OK);
	
}
}
