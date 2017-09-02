package edu.cs545.jungleResort.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cs545.jungleResort.domain.Admin;

@Repository
public interface AdminDAO extends CrudRepository<Admin, Integer>{
	@Query("FROM Admin a WHERE a.username= :username")
	public Admin getAdminByUsername(@Param("username") String username);
	
//	@Query("FROM Admin a WHERE a.password= :password")
//	public Admin getAdminByPassword(@Param("password") String password);
}
