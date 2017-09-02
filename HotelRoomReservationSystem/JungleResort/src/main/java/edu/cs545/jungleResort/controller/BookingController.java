package edu.cs545.jungleResort.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import edu.cs545.jungleResort.domain.Booking;
import edu.cs545.jungleResort.domain.Customer;
import edu.cs545.jungleResort.domain.Room;
import edu.cs545.jungleResort.enumeration.RoomStatus;
import edu.cs545.jungleResort.service.BookingService;
import edu.cs545.jungleResort.service.ICustomerService;
import edu.cs545.jungleResort.service.MailClient;
import edu.cs545.jungleResort.serviceImpl.RoomServiceImpl;

@Controller
public class BookingController {

	@Autowired
	RoomServiceImpl roomService;
	@Autowired
	ICustomerService customerService;
	@Autowired
	BookingService bookingService;
	@Autowired
	ServletContext servletContext;
	@Autowired
	MailClient mailClient;

	@RequestMapping(value = "/booking/{username}/{roomId}", method = RequestMethod.POST)
	public String booking(@PathVariable("roomId") int roomId, @PathVariable("username") String userName,
			Booking booking, @RequestParam("startDate") String startDateString,
			@RequestParam("endDate") String endDateString, HttpServletRequest request) throws java.text.ParseException {

		System.out.println("StartDate " + startDateString + "EndDate " + endDateString
				+ " inside booking room controller !!88888888888888888888888888888888888");
		Room room = roomService.getRoomById(roomId);
		Customer customer = customerService.getCustomerByUserName(userName);
		System.out.println(" customer name : " + customer.getEmail());
		booking.setRoomId(room.getId());
		booking.setRoomNo(room.getRoomNo());
		booking.setGuestNo(room.getGuestNo());
		booking.setRoomType(room.getRoomType());
		booking.setCustomerId(customer.getCustomerId());

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		booking.setStartDate(df.parse(startDateString));
		booking.setEndDate(df.parse(endDateString));

		Room myRoom = roomService.getRoomById(roomId);
		myRoom.setId(roomId);
		myRoom.setRoomStatus(RoomStatus.Rented);

		bookingService.saveBooking(booking);
		roomService.addRoom(myRoom);
		mailClient.sendMail(customer.getEmail(), "Thank for booking room!!",
				"This is an automated email send to you " + "since you booked a room in Jungle Side Resort !!");
		return "redirect:/profile/" + customer.getCustomerId();
	}

}
