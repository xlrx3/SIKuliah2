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

import com.excercise.college.dao.MajorDAO;
import com.excercise.college.models.Major;

@Controller
@Transactional
@EnableWebMvc
public class MajorController {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private MajorDAO majorDAO;

	@RequestMapping(value = "/majors", method = RequestMethod.GET)
	public String jurusanList(Model model) {
		List<Major> list = majorDAO.listAllMajor();
		model.addAttribute("jurusanInfo", list);
		return "majors/jurusanList";
	}

	private String formJurusan(Model model, Major jurusan) {
		model.addAttribute("jurusanForm", jurusan);

		if (jurusan.getIdJurusan() == null) {
			model.addAttribute("formTitle", "Create Major");
			model.addAttribute("method","POST");
		} else {
			model.addAttribute("formTitle", "Edit Major");
			model.addAttribute("method","POST");
		}
		return "majors/formJurusan";
	}

	private String formEditJurusan(Model model, Major jurusan) {
		model.addAttribute("jurusanForm", jurusan);

		if (jurusan.getIdJurusan() == null) {
			model.addAttribute("formTitle", "Create Major");
			model.addAttribute("method", "POST");
		} else {
			model.addAttribute("formTitle", "Edit Major");
			model.addAttribute("method", "PUT");
		}
		return "majors/formJurusanEdit";
	}

	@RequestMapping(value = "/major", method = RequestMethod.GET)
	public String createJurusan(Model model) {

		Major jurusan = new Major();

		return this.formJurusan(model, jurusan);
	}

	@RequestMapping(value = "/major/{id}/edit", method = RequestMethod.GET)
	public String editJurusan(Model model, @PathVariable("id") Integer id) {
		Major jurusan = null;
		if (id != null) {
			Major jur = majorDAO.getMajorById(id);

			if (jur == null) {
				return null;
			}

			jurusan = new Major(jur.getIdJurusan(), jur.getNamaJurusan(), jur.getFakultasJurusan(),
					jur.getKepalaJurusan(), jur.getCode());
		}
		if (jurusan == null) {
			return "redirect:/majors";
		}

		return this.formEditJurusan(model, jurusan);
	}

	@RequestMapping(value = "/major/{id}", method = RequestMethod.GET)
	public String deleteJurusan(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			majorDAO.deleteMajor(id);
		}
		return "redirect:/majors";
	}

	// public String refreshPage() {
	// return "redirect:/majors";
	// }

	@RequestMapping(value = "/major/save", method = RequestMethod.POST)
	/* example */
	public String saveJurusan(@ModelAttribute("jurusanForm") @Validated Major jurusan) {
		this.majorDAO.saveMajor(jurusan);
		return "redirect:/majors";
	}

	@RequestMapping(value = "/major/{id}/edit/save", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("jurusanForm") @Validated Major jurusan) {
		this.majorDAO.saveMajor(jurusan);
		return "redirect:/majors";
	}

}
