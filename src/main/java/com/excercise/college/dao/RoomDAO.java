package com.excercise.college.dao;

import java.util.List;

import com.excercise.college.forms.RoomForm;
import com.excercise.college.models.Major;
import com.excercise.college.models.Room;

public interface RoomDAO {
	public List<Room> listAllRoom();

	public Room getRoomById(Integer id);

	public void deleteRoom(Integer id);

	public void saveRoom(RoomForm room);
}
