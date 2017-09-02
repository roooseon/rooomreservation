package edu.cs545.jungleResort.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cs545.jungleResort.DAO.CustomerDAO;
import edu.cs545.jungleResort.domain.Admin;
import edu.cs545.jungleResort.domain.Customer;
import edu.cs545.jungleResort.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	CustomerDAO customerdao;
	
	@Override
	public List<Customer> getAllCustomer() {
		return (List<Customer>) customerdao.findAll();
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerdao.findOne(id);
	}

	@Override
	public void addCustomer(Customer customer) {
		customerdao.save(customer);
	}

	@Override
	public void updateCustomer(int id) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void deleteCustomer(int id) {
		customerdao.delete(id);
	}

	@Override
	public Customer getCustomerByUserName(String userName) {
		return customerdao.getCustomerByUsername(userName);
	}

	@Override
	public Customer getCustomerByUsernme(String username) {
		return customerdao.getCustomerByUsername(username);
	}

	@Override
	public boolean loginAuthenticateCust(String username, String password) {
		Customer customer = customerdao.getCustomerByUsername(username);

		if (customer != null) {
			if (username.equals(customer.getUsername()) && password.equals(customer.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
