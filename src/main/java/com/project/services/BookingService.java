package com.project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.exceptions.FlightTicketException;
import com.project.entities.AirlinesModel;
import com.project.entities.AirlinesRequestModel;
import com.project.entities.TicketModel;
import com.project.repository.BookingRepository;
import com.project.repository.SearchingRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository repo;
	@Autowired
	SearchingRepository srep;

	public TicketModel bookTicket(TicketModel model) {
		// TODO Auto-generated method stub
		return repo.save(model);
	}


	public List<TicketModel> getTicketDetailsById(Long id) throws FlightTicketException {
		// TODO Auto-generated method stub
		Optional<TicketModel> tckt=repo.findById(id);
		if(tckt.isPresent()) {
			List<TicketModel> tktList=new ArrayList<>();
			tktList.add(tckt.get());
			return tktList;
		}
		else
		throw new FlightTicketException("Invalid ticket");
		
	}

	public List<TicketModel> getTicketDetailsByEmailId(String emailId) throws FlightTicketException {
		// TODO Auto-generated method stub
		Optional<List<TicketModel>> tckt=repo.findByEmailId( emailId);
		if(tckt.isPresent()) {
			return tckt.get();
		}
		else
		throw new FlightTicketException("Ticket Details Not Found");
	}

	public List<AirlinesModel> searchFlight(AirlinesRequestModel post) {
		// TODO Auto-generated method stub
		
		return srep.search(post.getFromPlace(),post.getToPlace(),post.getTravelDate(),post.getTravelDate().plusDays(1));
	}

	public TicketModel cancelTicket(TicketModel model) {
		// TODO Auto-generated method stub
		return repo.save(model);
	}

	public List<TicketModel> getAllTicketDetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
