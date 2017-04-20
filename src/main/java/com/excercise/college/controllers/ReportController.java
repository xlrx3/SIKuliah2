package com.excercise.college.controllers;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.excercise.college.dao.ReportDAO;
import com.excercise.college.dao.StudentDAO;
import com.excercise.college.models.FRS;
import com.excercise.college.models.FRSDetail;
import com.excercise.college.models.Student;
import com.excercise.college.models.SubjectMajor;

@Controller
@Transactional
@EnableWebMvc
public class ReportController {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ReportDAO reportDAO;
	
	@Autowired
	private StudentDAO studentDAO;

	@RequestMapping(value = "/report/1", method = RequestMethod.GET)
	public String countMKJurusan(Model model) {
	
		List<Object[]> mkjList = reportDAO.getMajorsWithMostSubject();

		for (Object[] mkj : mkjList) {
			Hibernate.initialize(mkj[0]);
			// System.out.println("ddadada =" +mkj[0]);
		}

		model.addAttribute("repCount", mkjList);

		return "Reports/reportCount";
	}

	@RequestMapping(value = "/report/2", method = RequestMethod.GET)
	public String countMahasiswaMK(Model model) {

		List<Object[]> mhsList = reportDAO.getStudentsWithMostSubjects();

		for (Object[] mhs : mhsList) {
			Hibernate.initialize(mhs[0]);
			// System.out.println("ddadada =" +mkj[0]);
		}

		model.addAttribute("repCount", mhsList);

		return "Reports/mhsCount";
	}

	@RequestMapping(value = "report/3", method = RequestMethod.GET)
	public String countMKMahasiswa(Model model) {
		List<Object[]> mkList = reportDAO.getSubjectsWithMostStudents();

		for (Object[] mk : mkList) {
			Hibernate.initialize(mk[0]);
			// System.out.println("ddadada =" +mkj[0]);
		}

		model.addAttribute("repCount", mkList);

		return "Reports/mkCount";
	}
	
	@RequestMapping(value= "report/4/{id}", method= RequestMethod.GET)
	public String getSubjectsTakenByStudent(Model model, @PathVariable("id")Integer id){
		List<FRSDetail> subjectTaken= reportDAO.getSubjectsTakenByStudent(id);
		Student std=studentDAO.findStudentById(id);
		
		for(FRSDetail frsd : subjectTaken) {
			System.out.println("mk: "+ frsd.getMk().getNama_MK());
		}
		model.addAttribute("taken", subjectTaken);
		model.addAttribute("student", std);
		return "Reports/takenSubjects";
	}
	
	@RequestMapping(value="report/studentInMajor/{id}", method= RequestMethod.GET)
	public String getStudentsByMajorId(Model model, @PathVariable("id")Integer majorId) {
		model.addAttribute("listStudent",studentDAO.getStudentThatMajors(majorId));
		return "Reports/studentMajorList";
	}
	
	@RequestMapping(value = "report/mostStudent", method = RequestMethod.GET)
	public String countMostStudentMajors(Model model) {
		List<Object[]> mkList = reportDAO.getMajorsWithMostStudent();

		for (Object[] mk : mkList) {
			Hibernate.initialize(mk[0]);
			// System.out.println("ddadada =" +mkj[0]);
		}

		model.addAttribute("repCount", mkList);

		return "Reports/mostStudent";
	}
	
	@RequestMapping(value = "/report/creditsPerMajor", method = RequestMethod.GET)
	public String countCreditsMajor(Model model) {
	
		List<Object[]> mkjList = reportDAO.getTotalCreditsPerMajor();

		for (Object[] mkj : mkjList) {
			Hibernate.initialize(mkj[0]);
			// System.out.println("ddadada =" +mkj[0]);
		}

		model.addAttribute("repCount", mkjList);

		return "Reports/creditMajor";
	}
}
