package com.excercise.college.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.excercise.college.forms.FRSForm;
import com.excercise.college.forms.ScheduleForm;
import com.excercise.college.forms.StudentForm;
import com.excercise.college.forms.SubjectMajorForm;
import com.excercise.college.models.FRS;
import com.excercise.college.models.Major;
import com.excercise.college.models.Schedule;
import com.excercise.college.models.Student;
import com.excercise.college.models.Subject;
import com.excercise.college.models.SubjectMajor;

@Controller
@Transactional
@EnableWebMvc
public class MainController {

	@Autowired
	private SessionFactory sessionFactory;

	@RequestMapping("/contoh")
	public String getContoh(Model model) {
		return "contoh";
	}

	@RequestMapping("/")
	public String mainPage(Model model) {
		return "main";
	}

	@RequestMapping("/reportList")
	public String reportPage(Model model) {
		return "reportList";
	}
	
	@RequestMapping("/main")
	public String goToMain(Model model) {
		return "redirect:/";
	}

}
