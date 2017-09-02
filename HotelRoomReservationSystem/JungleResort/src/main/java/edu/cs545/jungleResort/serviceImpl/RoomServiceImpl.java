package edu.cs545.jungleResort.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cs545.jungleResort.DAO.BookingDAO;
import edu.cs545.jungleResort.DAO.RoomDAO;
import edu.cs545.jungleResort.domain.Booking;
import edu.cs545.jungleResort.domain.Room;
import edu.cs545.jungleResort.enumeration.RoomStatus;
import edu.cs545.jungleResort.enumeration.RoomType;
import edu.cs545.jungleResort.service.IRoomService;

@Service
@Transactional
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private RoomDAO roomdao;

	@Autowired
	private BookingDAO bookingDao;

	@Override
	public Room addRoom(Room room) {
		return roomdao.save(room);
	}

	@Override
	public void deleteRoom(int id) {
		roomdao.delete(id);
	}

	@Override
	public Room getRoomById(int id) {
		return roomdao.findOne(id);
	}

	@Override
	public List<Room> getAllRoom() {
		return (List<Room>) roomdao.findAll();
	}

	@Override
	public List<Room> getAllAvailableRoom() {
		List<Room> allRooms = (List<Room>) roomdao.findAll();
		List<Room> avaialbleRooms = new ArrayList<Room>();
		for (Room r : allRooms) {
			if (r.getRoomStatus().equals(RoomStatus.Available)) {
				avaialbleRooms.add(r);
			}
		}
		return avaialbleRooms;
	}

	@Override
	public void scheduledTask() {
		System.out.println("inside task schedular !!");
		List<Booking> bookingList = (List<Booking>) bookingDao.findAll();

		for (Booking booking : bookingList) {
			if (booking.getEndDate() != null) {

				Date today = Calendar.getInstance().getTime();
				System.out.println("Todays date is : " + today);
				System.out.println("Date in the end Date : " + booking.getEndDate());
				if ((today).compareTo((Date) booking.getEndDate()) > 0) {
					System.out.println("today is after endDate");
					Room room = (Room) roomdao.findRoomByNumber(booking.getRoomId());
					room.setRoomStatus(RoomStatus.Available);

					roomdao.save(room);
				}
			}
		}
	}

	@Override
	public List<Room> getRoomsByType(RoomType type) {

		List<Room> roomsByType = (List<Room>) roomdao.getRoomByType(type);
		return roomsByType;
	}
}
