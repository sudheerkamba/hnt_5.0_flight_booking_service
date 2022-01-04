package com.project.tests;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.greaterThan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entities.TicketModel;
import com.project.exceptions.FlightTicketException;
import com.project.services.BookingService;

@SpringBootTest
class EurekaServerApplicationTests {

	@Autowired
	BookingService bookingService;
	
	@Test
	public void shouldGetTicketById()
	{
		Long l=100001L;
		try {
			List<TicketModel> tktModel= bookingService.getTicketDetailsById(l);
			Assertions.assertNotNull(tktModel);
			Assertions.assertNotNull(tktModel.get(0));
			MatcherAssert.assertThat(tktModel.get(0).getPnrNumber(), greaterThan(1L));

			
		} catch (FlightTicketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void shouldNotGetTicketById()
	{
		Long l=100L;
		try {
			List<TicketModel> tktModel= bookingService.getTicketDetailsById(l);
			Assertions.assertNull(tktModel);
			Assertions.assertThrows(RuntimeException.class, ()->{
				bookingService.getTicketDetailsById(l);
			});
		
		} catch (FlightTicketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void shouldGetTicketByEmailId()
	{
		String emailId="nikil@gmail.com";
		try {
			List<TicketModel> tktModel= bookingService.getTicketDetailsByEmailId(emailId);
			Assertions.assertNotNull(tktModel);
			Assertions.assertNotNull(tktModel.get(0));
			MatcherAssert.assertThat(tktModel.get(0).getPnrNumber(), greaterThan(1L));

			
		} catch (FlightTicketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void shouldNotGetTicketByEmailId()
	{
		String emailId="sun@gmail.com";
		try {
			List<TicketModel> tktModel= bookingService.getTicketDetailsByEmailId(emailId);
			Assertions.assertTrue(tktModel.isEmpty());
			/*
			 * Assertions.assertThrows(RuntimeException.class, ()->{
			 * bookingService.getTicketDetailsByEmailId(emailId); });
			 */
		
		} catch (FlightTicketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
