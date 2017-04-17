package com.excercise.college.controllers;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

import com.excercise.college.dao.SubjectDAO;
import com.excercise.college.enums.Semester;
import com.excercise.college.enums.Status;
import com.excercise.college.models.Subject;

@Controller
@Transactional
@EnableWebMvc
public class SubjectController {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private SubjectDAO subjectDAO;

	@RequestMapping(value = "/subjects", method = RequestMethod.GET)
	public String mataKuliahList(Model model) {
		List<Subject> list = subjectDAO.getAllSubjects();
		model.addAttribute("mKInfo", list);
		return "subjects/mataKuliahList";
	}

	private String formMataKuliah(Model model, Subject mataKuliah) {
		model.addAttribute("mataKuliahForm", mataKuliah);
		
		model.addAttribute("smtList", Semester.values());

		if (mataKuliah.getId_MK() == null) {
			model.addAttribute("formTitle", "Create MK");
		} else {
			model.addAttribute("formTitle", "Edit MK");
		}
		return "subjects/formMataKuliah";
	}

	private String formEditMataKuliah(Model model, Subject mataKuliah) {
		model.addAttribute("mataKuliahForm", mataKuliah);
		
		model.addAttribute("smtList", Semester.values());

		if (mataKuliah.getId_MK() == null) {
			model.addAttribute("formTitle", "Create MK");
		} else {
			model.addAttribute("formTitle", "Edit MK");
		}
		return "subjects/formEditMataKuliah";
	}

	@RequestMapping(value = "/subject", method = RequestMethod.GET)
	public String createMataKuliah(Model model) {

		Subject mk = new Subject();

		return this.formMataKuliah(model, mk);
	}

	@RequestMapping(value = "/subject/{id}/edit", method = RequestMethod.GET)
	public String editMataKuliah(Model model, @PathVariable("id") Integer id) {
		Subject matkul = null;
		if (id != null) {

			Subject mk = this.subjectDAO.getSubjectById(id);

			if (mk == null) {
				return null;
			}

			matkul = new Subject(mk.getId_MK(), mk.getNama_MK(), mk.getSKS(), mk.getSemester());
		}
		if (matkul == null) {
			return "redirect:/subjects";
		}

		return this.formEditMataKuliah(model, matkul);
	}

	@RequestMapping(value = "/subject/{id}", method = RequestMethod.DELETE)
	public String deleteMataKuliah(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			this.subjectDAO.deleteSubject(id);
		}
		return "redirect:/subjects";
	}

	@RequestMapping(value = "/subject", method = RequestMethod.POST)
	/* example */
	public String saveMataKuliah(@ModelAttribute("mataKuliahForm") @Validated Subject matkul) {
		subjectDAO.saveSubject(matkul);
		return "redirect:/subjects";
	}

	@RequestMapping(value = "/subject/{id}/edit/save", method = RequestMethod.POST)
	public String saveEditMataKuliah(@ModelAttribute("mataKuliahForm") @Validated Subject matkul) {
		subjectDAO.saveSubject(matkul);
		return "redirect:/subjects";
	}

}
