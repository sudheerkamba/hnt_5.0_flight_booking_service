package com.project.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entities.AirlinesModel;

@Repository
public interface SearchingRepository extends JpaRepository<AirlinesModel, Integer>{
	
	@Query("select m from airlines m where m.fromPlace=?1 and m.toPlace=?2 and m.startTime>=?3 and m.startTime<?4  and m.is_blocked='N'")
	public List<AirlinesModel> search(String fromPlace, String toPlace, LocalDateTime travelDate, LocalDateTime travelDateplus);

}
