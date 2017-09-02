package edu.cs545.jungleResort.DAO;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cs545.jungleResort.domain.Room;
import edu.cs545.jungleResort.enumeration.RoomType;

@Repository
public interface RoomDAO extends CrudRepository<Room, Integer>{
	
	@Query("FROM Room r WHERE r.roomNo= :roomNo")
	public Room findRoomByNumber(@Param("roomNo") Integer roomNo);
	
	@Query("FROM Room r WHERE r.roomType= :roomType")
	public List<Room> getRoomByType(@Param("roomType") RoomType roomType );
}

