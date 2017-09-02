package edu.cs545.jungleResort.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;

import org.hibernate.validator.constraints.EAN;
import org.springframework.format.annotation.DateTimeFormat;

import edu.cs545.jungleResort.enumeration.RoomType;


@Entity
public class Booking {
	@Id
	@GeneratedValue
	private int id;
	private int roomId;
	private int customerId;
	private int roomNo;
	private int guestNo;
	@Enumerated(EnumType.STRING)
	private RoomType roomType;
	
	@Future
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date startDate;
	
	@Future
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date endDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getGuestNo() {
		return guestNo;
	}

	public void setGuestNo(int guestNo) {
		this.guestNo = guestNo;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	
}