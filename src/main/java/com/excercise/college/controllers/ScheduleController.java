package com.excercise.college.controllers;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.excercise.college.dao.ScheduleDAO;
import com.excercise.college.dao.SubjectDAO;
import com.excercise.college.enums.Days;
import com.excercise.college.enums.Status;
import com.excercise.college.forms.ScheduleForm;
import com.excercise.college.models.Schedule;
import com.excercise.college.models.Subject;

@Controller
@Transactional
@EnableWebMvc
public class ScheduleController {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ScheduleDAO scheduleDAO;
	
	@Autowired
	private SubjectDAO subjectDAO;

	@RequestMapping(value = "/schedules", method = RequestMethod.GET)
	public String jadwalList(Model model) {
		List<Schedule> list = scheduleDAO.listAllSchedule();
		model.addAttribute("jadwalInfo", list);
		return "Schedules/jadwalList";
	}

	private String formJadwal(Model model, ScheduleForm jadwal) {
		model.addAttribute("jadwalForm", jadwal);

		List<Subject> mk = subjectDAO.getAllSubjects();

		model.addAttribute("id_mk", mk);
		
		model.addAttribute("daysList", Days.values());

		if (jadwal.getId() == null) {
			model.addAttribute("formTitle", "Create Jadwal");
		} else {
			model.addAttribute("formTitle", "Edit Jadwal");
		}
		return "Schedules/formJadwal";
	}

	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	public String createJadwal(Model model) {

		ScheduleForm jadwal = new ScheduleForm();
	
		return this.formJadwal(model, jadwal);
	}

	@RequestMapping(value = "/schedule/{id}/edit", method = RequestMethod.GET)
	public String editJadwal(Model model, @PathVariable("id") Integer id) {
		ScheduleForm jadwal = null;
		if (id != null) {
			Schedule jad = scheduleDAO.getScheduleById(id);

			if (jad == null) {
				return null;
			}

			jadwal = new ScheduleForm();
			jadwal.setId(jad.getId());
			jadwal.setHari(jad.getHari());
			jadwal.setIdMK(jad.getMk().getId_MK());
			jadwal.setJam_mulai(jad.getJam_mulai());
			jadwal.setJam_selesai(jad.getJam_selesai());
			jadwal.setRuangan(jad.getRuangan());
		}
		if (jadwal == null) {
			return "redirect:/schedules";
		}

		return this.formJadwal(model, jadwal);
	}

	@RequestMapping(value = "/schedule/{id}", method = RequestMethod.GET)
	public String deleteJadwal(Model model, @PathVariable("id") Integer id) {
		scheduleDAO.deleteSchedule(id);
		return "redirect:/schedules";
	}

	@RequestMapping(value = "/schedule", method = RequestMethod.POST)
	/* example */
	public String saveMahasiswa(@ModelAttribute("jadwalForm") @Validated ScheduleForm jadwal) {
		scheduleDAO.saveSchedule(jadwal);
		System.out.println();
		return "redirect:/schedules";
	}
	
	
}
