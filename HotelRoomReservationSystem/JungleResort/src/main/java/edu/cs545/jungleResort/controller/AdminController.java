package edu.cs545.jungleResort.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.cs545.jungleResort.DAO.AdminDAO;
import edu.cs545.jungleResort.domain.Admin;

@Controller
public class AdminController {
	@Autowired
	AdminDAO admindao;

	@RequestMapping(value = "/addadmin", method = RequestMethod.GET)
	public String addAdminGet(@ModelAttribute Admin admin) {
		return "AddAdmin";
	}

	@RequestMapping(value = "/addadmin", method = RequestMethod.POST)
	public String addAdminPost(@ModelAttribute @Valid Admin admin, BindingResult result, Model model) {
		String view = "AddAdmin";
		if (admin.getPassword().equals(admin.getConfirmPassword())) {
			if (!result.hasErrors()) {
				try{
				admindao.save(admin);
				view= "redirect:/adminlogin";
				}
				catch(Exception e){
					model.addAttribute("userexists", new String("Username already exists"));
				}
			} else
				return view;
		} else {
			model.addAttribute("passmismatch", new String("password mismatch"));
			return view;
		}
		return view;
	}
}