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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.excercise.college.dao.MajorDAO;
import com.excercise.college.dao.SubjectDAO;
import com.excercise.college.dao.SubjectMajorDAO;
import com.excercise.college.forms.SubjectMajorForm;
import com.excercise.college.models.Major;
import com.excercise.college.models.Subject;
import com.excercise.college.models.SubjectMajor;

@Controller
@Transactional
@EnableWebMvc
public class SubjectMajorController {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private SubjectMajorDAO subjectMajorDAO;
	
	@Autowired
	private SubjectDAO subjectDAO;
	
	@Autowired
	private MajorDAO majorDAO;

	@RequestMapping(value="/subjectMajors", method=RequestMethod.GET)
	public String mKJurList(Model model) {;
		List<SubjectMajor> list = subjectMajorDAO.listAllSubjectMajor();
		model.addAttribute("mKJurInfo", list);

		return "SubjectsMajor/mKJurList";
	}

	private String formMKJur(Model model, SubjectMajorForm mkjf) {
		model.addAttribute("mKJurForm", mkjf);
		List<Major> jur = majorDAO.listAllMajor();

		model.addAttribute("jurusan", jur);

		List<Subject> mk = subjectDAO.getAllSubjects();

		model.addAttribute("mataKuliah", mk);

		if (mkjf.getId() == null) {
			model.addAttribute("formTitle", "Create MK Jurusan");
		} else {
			model.addAttribute("formTitle", "Edit MK Jurusan");
		}

		return "SubjectsMajor/formMKJur";
	}

	@RequestMapping(value="/subjectMajor", method=RequestMethod.GET)
	public String createMKJur(Model model) {

		SubjectMajorForm mkjf = new SubjectMajorForm();

		return this.formMKJur(model, mkjf);
	}

	@RequestMapping(value="/subjectMajor/{id}/edit", method=RequestMethod.GET)
	public String editMKJur(Model model, @PathVariable("id") Integer id) {
		SubjectMajorForm mkjf = null;
		Major jurusan = null;
		if (id != null) {

			SubjectMajor mkJur = subjectMajorDAO.getSubjectMajorbyId(id);

			mkjf = new SubjectMajorForm();
			mkjf.setId(mkJur.getId());
			mkjf.setId_jur(mkJur.getJurusan().getIdJurusan());
			mkjf.setId_MK(mkJur.getMk().getId_MK());

		}
		if (mkjf == null) {
			return "redirect:/subjectMajors";
		}

		return this.formMKJur(model, mkjf);
	}

	@RequestMapping(value="/subjectMajor/{id}", method=RequestMethod.GET)
	public String deleteMKJur(Model model, @PathVariable("id") Integer id) {
		subjectMajorDAO.deleteSubjectMajor(id);
		return "redirect:/subjectMajors";
	}

	@RequestMapping(value = "/subjectMajor", method = RequestMethod.POST)
	public String saveMKJur(@ModelAttribute("mKJurForm") SubjectMajorForm mkjf) {
		subjectMajorDAO.saveSubjectMajor(mkjf);
		return "redirect:/subjectMajors";
	}

}
