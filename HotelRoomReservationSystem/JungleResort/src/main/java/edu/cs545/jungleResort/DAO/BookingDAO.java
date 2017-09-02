package edu.cs545.jungleResort.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cs545.jungleResort.domain.Booking;

@Repository
public interface BookingDAO extends CrudRepository <Booking, Integer>{
	
	
	@Query("FROM Booking bok WHERE bok.customerId= :customerId")
	public List<Booking> findByCustomerId(@Param("customerId") int customerId);


}