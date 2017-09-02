package edu.cs545.jungleResort.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cs545.jungleResort.domain.Customer;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Integer>{
	@Query("FROM Customer cus WHERE cus.username= :username")
	public Customer getCustomerByUsername(@Param("username") String username);
}
