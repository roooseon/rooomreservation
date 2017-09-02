package edu.cs545.jungleResort.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.cs545.jungleResort.DAO.CustomerDAO;
import edu.cs545.jungleResort.domain.Customer;
import edu.cs545.jungleResort.service.BookingService;
import edu.cs545.jungleResort.service.ICustomerService;

@Controller
public class CustomerController {
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	BookingService bookingService;

	@RequestMapping(value = "/addcustomer", method = RequestMethod.GET)
	public String addCustomerGet(@ModelAttribute Customer customer) {
		return "AddCustomer";
	}
	
	@RequestMapping(value = "/profile/{customerId}", method = RequestMethod.GET)
	public String getProfile(Model model, @PathVariable("customerId") int customerId) {
		model.addAttribute("booking", bookingService.getBookingByCustomerId(customerId));
		model.addAttribute("customer", customerService.getCustomerById(customerId));
		return "profile";
	}

	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public String addCustomerPost(@ModelAttribute @Valid Customer customer, BindingResult result, Model model) {
		String view = "AddCustomer";
		if (customer.getPassword().equals(customer.getConfirmPassword())) {
			if (!result.hasErrors()) {
				try{
					customerService.addCustomer(customer);
				view= "redirect:/customerlogin";
				}
				catch(Exception e){
					model.addAttribute("userexistscust", new String("Username already exists"));
				}
			} else {
				return view;
			}
		} else {
			model.addAttribute("passmismatchcust", new String("password mismatch"));
			return view;
		}
		return view;
	}
}