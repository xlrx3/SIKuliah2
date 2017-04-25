package com.excercise.college.controllers;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.excercise.college.dao.RoomDAO;
import com.excercise.college.forms.RoomForm;
import com.excercise.college.forms.StudentForm;
import com.excercise.college.models.Major;
import com.excercise.college.models.Room;
import com.excercise.college.models.Student;

@Controller
@Transactional
@EnableWebMvc
public class RoomController {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private RoomDAO roomDAO;
	
	@RequestMapping(value = "/rooms", method = RequestMethod.GET)
	public String jurusanList(Model model) {
		List<Room> list = roomDAO.listAllRoom(); 
		model.addAttribute("roomList", list);
		return "Rooms/roomList";
	}
	
	private String formRoom(Model model, RoomForm rf) {
		model.addAttribute("roomForm", rf);

		if (rf.getId() == null) {
			model.addAttribute("formTitle", "Create Room");
			model.addAttribute("method","POST");
		} else {
			model.addAttribute("formTitle", "Edit Room");
			model.addAttribute("method","POST");
		}
		return "Rooms/formRoom";
	}
	
	@RequestMapping(value = "/room", method = RequestMethod.GET)
	public String createJurusan(Model model) {

		RoomForm room = new RoomForm();

		return this.formRoom(model, room);
	}
	
	 @RequestMapping(value="/room/{id}/edit", method=RequestMethod.GET)
	 public String editMahasiswa(Model model, @PathVariable("id") Integer id)
	 {
	 RoomForm rf = null;
	 if (id != null) {
	Room room = roomDAO.getRoomById(id);
	 
	 if (room == null) {
	 return null;
	 }
	
	 rf = new RoomForm();
	 rf.setId(room.getId());
	 rf.setBuildingNum(room.getBuildingNum());
	 rf.setFloorNum(room.getFloorNum());
	 rf.setName(room.getName());
	 rf.setRoomCode(room.getRoomCode()-(room.getBuildingNum()*1000)-(room.getFloorNum()*100));
	 
	 }
	 if (rf == null) {
	 return "redirect:/rooms";
	 }
	
	 return this.formRoom(model, rf);
	 }
	 
	 @RequestMapping(value="/room/{id}", method=RequestMethod.GET)
	 public String deleteRoom(Model model, @PathVariable("id") Integer
	 id) {
	 if (id != null) {
	 roomDAO.deleteRoom(id);
	 }
	 return "redirect:/rooms";
	 }
	
	 @RequestMapping(value = "/room", method = RequestMethod.POST)
	 public String saveRoom(@ModelAttribute("roomForm") @Validated
	 RoomForm room){
	 roomDAO.saveRoom(room);
	 return "redirect:/rooms";
	 }
}
