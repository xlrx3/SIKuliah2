package com.excercise.college.controllers;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.excercise.college.dao.MajorDAO;
import com.excercise.college.dao.StudentDAO;
import com.excercise.college.enums.Status;
import com.excercise.college.forms.StudentForm;
import com.excercise.college.models.Major;
import com.excercise.college.models.Student;

@Controller
@Transactional
@EnableWebMvc
public class StudentController {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private MajorDAO majorDAO;

	@Autowired
	private StudentDAO studentDAO;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String mahasiswaList(Model model) {
		// String sql = "Select new " + Mahasiswa.class.getName()
		// + "(a.NPM, a.nama, a.angkatan, a.status, a.jurusan) "
		// + " from " + Mahasiswa.class.getName() + " a ";

		// Query query = session.createQuery(sql);
		List<Student> list = studentDAO.listAllStudents();
		model.addAttribute("mahasiswaInfo", list);
		return "students/mahasiswaList";
	}

	private String formMahasiswa(Model model, StudentForm mahasiswa) {
		model.addAttribute("mahasiswaForm", mahasiswa);
//		System.out.println(Status.values());
//		   for(Status mkj:Status.values()) {
//		   System.out.println("id: " + mkj);
//	   }
		model.addAttribute("statsList", Status.values());

		List<Major> jurusan = majorDAO.listAllMajor();
		// System.out.println(jurusan.isEmpty());
		model.addAttribute("idJur", jurusan);

		if (mahasiswa.getId() == null) {
			model.addAttribute("formTitle", "Create Mahasiswa");
//			model.addAttribute("action","student");
			
		} else {
			model.addAttribute("formTitle", "Edit Mahasiswa");
//			model.addAttribute("action","/student");
		}
		return "students/formMahasiswa";
	}

	//
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String createMahasiswa(Model model) {

		StudentForm mahasiswa = new StudentForm();

		return this.formMahasiswa(model, mahasiswa);
	}
	//
	 @RequestMapping(value="/student/{id}/edit", method=RequestMethod.GET)
	 public String editMahasiswa(Model model, @PathVariable("id") Integer id)
	 {
	 StudentForm mahasiswa = null;
	 if (id != null) {
	 Student mhs = studentDAO.findStudentById(id);
	
	 if (mhs == null) {
	 return null;
	 }
	
	 mahasiswa = new StudentForm(mhs.getId(),mhs.getNPM(),
	 mhs.getNama(),mhs.getAngkatan(),mhs.getStatus(),mhs.getJurusan().getIdJurusan());
	 }
	 if (mahasiswa == null) {
	 return "redirect:/students";
	 }
	
	 return this.formMahasiswa(model, mahasiswa);
	 }
	
	 @RequestMapping(value="/student/{id}", method=RequestMethod.GET)
	 public String deleteMahasiswa(Model model, @PathVariable("id") Integer
	 id) {
	 if (id != null) {
	 studentDAO.deleteStudent(id);
	 }
	 return "redirect:/students";
	 }
	
	 @RequestMapping(value = "/student", method = RequestMethod.POST)
	 public String saveMahasiswa(@ModelAttribute("mahasiswaForm") @Validated
	 StudentForm mahasiswa){
	 studentDAO.saveStudent(mahasiswa);
	 return "redirect:/students";
	 }
}
