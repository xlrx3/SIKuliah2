package com.excercise.college.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.excercise.college.dao.RoomDAO;
import com.excercise.college.forms.RoomForm;
import com.excercise.college.models.Major;
import com.excercise.college.models.Room;
import com.excercise.college.models.Schedule;
import com.excercise.college.models.Student;

public class RoomDAOImpl implements RoomDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Room> listAllRoom() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Room.class, "room");
		criteria.addOrder(Order.desc("id"));
		return criteria.list();
	}

	@Override
	public Room getRoomById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Room.class);
		crit.add(Restrictions.eq("id", id));
		return (Room) crit.uniqueResult();
	}

	@Override
	public void deleteRoom(Integer id) {
		Session session = sessionFactory.getCurrentSession();

		Criteria crit = session.createCriteria(Room.class);
		crit.add(Restrictions.eq("id", id));

		Room rm = (Room) crit.uniqueResult();
		if (rm != null) {
			this.sessionFactory.getCurrentSession().delete(rm);
		}
		
	}

	@Override
	public void saveRoom(RoomForm room) {
		
		Integer id = room.getId();
		Integer floorNum = room.getFloorNum();
		Integer buildNum = room.getBuildingNum();
		Integer roomNum=room.getRoomCode();
		Room rm = null;
//		Major jur = majorDAO.getMajorById(mahasiswa.getIdJur());
		
		if (id != null) {
		rm = this.getRoomById(id);
		}

		boolean isNew = false;
		if (rm == null) {
			isNew = true;
			rm = new Room();
		}

		rm.setBuildingNum(room.getBuildingNum());
		rm.setFloorNum(room.getFloorNum());
		rm.setName(room.getName());
		rm.setRoomCode((buildNum*1000)+(floorNum*100)+roomNum);

		if (isNew) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(rm);
		}
		
	}

}
