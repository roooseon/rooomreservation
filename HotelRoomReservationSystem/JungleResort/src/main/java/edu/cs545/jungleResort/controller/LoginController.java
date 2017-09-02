package edu.cs545.jungleResort.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import edu.cs545.jungleResort.domain.Admin;
import edu.cs545.jungleResort.domain.Customer;
import edu.cs545.jungleResort.service.IAdminService;
import edu.cs545.jungleResort.service.ICustomerService;

@Controller
public class LoginController {

	int roomId = -1;
	@Autowired
	IAdminService adminservice;

	@Autowired
	ICustomerService customerservice;

	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String adminLoginGet() {
		return "AdminLogin";
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public String adminLoginPost(@CookieValue(value = "username", defaultValue = "") String username, Model model,
			HttpSession session, @ModelAttribute Admin admin, boolean remember, HttpServletResponse response) {

		System.out.println("Admin username = " + admin.getUsername());
		System.out.println("Admin password = " + admin.getPassword());
		if (adminservice.loginAuthenticate(admin.getUsername(), admin.getPassword())) {
			System.out.println("login auth successful");
			if (remember && username.isEmpty()) {
				Cookie cookie = new Cookie("usernameAdmin", admin.getUsername());
				cookie.setMaxAge(30 * 24 * 60 * 60);
				response.addCookie(cookie);
			}

			else if (!remember) {
				Cookie cookie = new Cookie("usernameAdmin", null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			session.setAttribute("adminSession", admin);
			System.out.println("Inside Admin Login after session!!");
			// redirectAttributes.addFlashAttribute("usernameFlash",
			// user.getUsername());
			return "redirect:/allroomslist";
		} else {
			System.out.println("Inside Admin Login Before session --- Login failed!!");
			System.out.println("loginFailed");
			model.addAttribute("loginfail", "Username/password is incorrect");
			return "AdminLogin";
		}
	}

	@RequestMapping(value = "/customerlogin", method = RequestMethod.GET)
	public String customerLoginGet() {
		return "CustomerLogin";
	}

	@RequestMapping(value = "/customerlogin/{roomId}", method = RequestMethod.GET)
	public String customerAuthenticate(Model model, @PathVariable("roomId") int id) {

		System.out.println("8888888888888888888888888888888888888888 " + id + " 77777777777777777777");
		// model.addAttribute("roomId", id);
		roomId = id;
		return "CustomerLogin";
	}

	@RequestMapping(value = "/customerlogin", method = RequestMethod.POST)
	public String customerLoginPost(@CookieValue(value = "username", defaultValue = "") String username, Model model,
			HttpSession session, @ModelAttribute Customer customer, boolean remember, HttpServletRequest request,
			HttpServletResponse response) {
		if (customerservice.loginAuthenticateCust(customer.getUsername(), customer.getPassword())) {
			System.out.println("login auth successful");
			if (remember && username.isEmpty()) {
				Cookie cookie = new Cookie("usernameCust", customer.getUsername());
				cookie.setMaxAge(30 * 24 * 60 * 60);
				response.addCookie(cookie);
			}

			else if (!remember) {
				Cookie cookie = new Cookie("usernameCust", null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			session.setAttribute("user", customer);

			// redirectAttributes.addFlashAttribute("usernameFlash",
			// user.getUsername());

			System.out.println("898988989898989888989898989 " + roomId + " 78787787878777878");
			if (roomId > 0) {
				return "redirect:/roomDetail/" + roomId;
			}
			return "redirect:/availableroomslist";
		} else {
			System.out.println("loginFailed");
			model.addAttribute("loginfail", "Username/password is incorrect");
			return "CustomerLogin";
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/customerlogin";
	}
}