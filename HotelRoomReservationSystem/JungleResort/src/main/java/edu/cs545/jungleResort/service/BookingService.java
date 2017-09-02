package edu.cs545.jungleResort.service;

import java.util.List;

import edu.cs545.jungleResort.domain.Booking;

public interface BookingService {
	public void saveBooking(Booking booking);

	public void deleteBookingById(int bookingId);

	public Booking getBookingById(int bookingId);

	public List<Booking> getBookingByCustomerId(int customerId);
	// public void updateBooking(Booking booking);
}