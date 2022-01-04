package com.project.repository;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.QueryParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entities.TicketModel;

@Repository
public interface BookingRepository extends JpaRepository<TicketModel, Long>{
	
	//@Query("select T, P from booking_details T inner join passenger_details P where T.emailId=?1")
	 Optional<List<TicketModel>> findByEmailId(String emailId);
		

}
