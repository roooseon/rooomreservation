package edu.cs545.jungleResort.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.cs545.jungleResort.domain.Rent;

@Repository
public interface RentDAO extends CrudRepository <Rent, Integer>{

}
