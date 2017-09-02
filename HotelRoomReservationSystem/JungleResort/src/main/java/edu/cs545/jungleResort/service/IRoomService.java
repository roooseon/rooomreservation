package edu.cs545.jungleResort.service;

import java.util.List;

import edu.cs545.jungleResort.domain.Room;
import edu.cs545.jungleResort.enumeration.RoomType;

public interface IRoomService {
	public Room addRoom(Room room);
	public void deleteRoom(int id);
	public Room getRoomById(int id);
	public List<Room> getAllRoom();
	public List<Room> getAllAvailableRoom();
	public void scheduledTask();
	public List<Room> getRoomsByType(RoomType type);
}
