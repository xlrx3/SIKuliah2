package com.excercise.college.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.excercise.college.dao.FRSDAO;
import com.excercise.college.dao.FRSDetailDAO;
import com.excercise.college.dao.StudentDAO;
import com.excercise.college.dao.SubjectDAO;
import com.excercise.college.dao.SubjectMajorDAO;
import com.excercise.college.enums.Semester;
import com.excercise.college.enums.Status;
import com.excercise.college.forms.FRSForm;
import com.excercise.college.models.FRS;
import com.excercise.college.models.FRSDetail;
import com.excercise.college.models.Student;
import com.excercise.college.models.Subject;
import com.excercise.college.models.SubjectMajor;

@Controller
@Transactional
@EnableWebMvc
public class FRSController {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private FRSDAO frsDAO;
	
	@Autowired
	private SubjectDAO subjectDAO;
	
	@Autowired
	private SubjectMajorDAO subjectMajorDAO;
	
	@Autowired
	private FRSDetailDAO frsDetailDAO;

	@RequestMapping(value="/FRSs", method=RequestMethod.GET)
	public String frsList(Model model) {
		List<Object[]> list = frsDAO.listAllFRS();
		model.addAttribute("frsInfo", list);

		return "FRS/frsList";
	}
	
	private String formFRS(Model model, FRSForm frsInfo, Student mhs) {
		
		model.addAttribute("frsFormCreate", frsInfo);
		
		System.out.println(mhs.getId());
		
		Integer NPM = mhs.getId();
		model.addAttribute("mhsNPM", NPM);
		
		List<SubjectMajor> mkjList = subjectMajorDAO.listAllSubjectMajorByMajors(mhs.getJurusan().getIdJurusan());


//		System.out.println(frsInfo.getSemesters());
		Integer smtNum=frsInfo.getSemesters();
		model.addAttribute("semesters",smtNum);
		Semester smt=frsInfo.getSemesterFromSemesterNum(smtNum);
		model.addAttribute("semester",smt);
		mkjList=this.filterSubjectBySemester(mkjList, smt);
		
		for (SubjectMajor mkj : mkjList) {
//			System.out.println(mkj.getMk().getNama_MK());
			Hibernate.initialize(mkj.getMk().getNama_MK());
		}
		
		model.addAttribute("mataKuliah", mkjList);

		if (frsInfo.getId() == null) {
			model.addAttribute("formTitle", "Create Frs");
		} else {
			model.addAttribute("formTitle", "Edit Frs");
		}
		
		return "FRS/formFRSCreate";
	}
	
private String formPRS(Model model, FRSForm frsInfo, Student mhs) {
		
		model.addAttribute("prsFormCreate", frsInfo);
		
		
		Integer NPM = mhs.getId();
		model.addAttribute("mhsNPM", NPM);
		
		Semester smt=frsInfo.getSemester();
		model.addAttribute("semester",smt);

		List<FRSDetail> listDetail= frsDetailDAO.getAllDetailFromFRSId(frsInfo.getId());
		
		for (FRSDetail frsd: listDetail) {
			Hibernate.initialize(frsd.getMk().getNama_MK());
		}
		
		List<SubjectMajor> listUnique=subjectMajorDAO.listAllUniqueSubject(listDetail, mhs.getJurusan().getIdJurusan(), smt);
		
		model.addAttribute("mataKuliah", listDetail);
		model.addAttribute("unikMK", listUnique);

		if (frsInfo.getId() == null) {
			model.addAttribute("formTitle", "Create Frs");
		} else {
			model.addAttribute("formTitle", "Edit Frs");
		}
		
		return "FRS/formPRS";
	}
	

//	private String formFRSEdit(Model model, FRSForm frsf, Student mhs) {
//		model.addAttribute("frsForm", frsf);
//
//		Session session = sessionFactory.getCurrentSession();
//		// Criteria crit = session.createCriteria(Mahasiswa.class);
//		//
//		// List<Mahasiswa> mhs = crit.list();
//
//		// model.addAttribute("mahasiswa", mhs);
//		Integer NPM = mhs.getId();
//		model.addAttribute("mhsNPM", NPM);
//		
//		List<SubjectMajor> mkjList = subjectMajorDAO.listAllSubjectMajorByMajors(mhs.getJurusan().getIdJurusan());
//
//		for (SubjectMajor mkj : mkjList) {
//			Hibernate.initialize(mkj.getMk().getNama_MK());
//		}
//
//		model.addAttribute("mataKuliah", mkjList);
//
//		if (frsf.getId() == null) {
//			model.addAttribute("formTitle", "Create FRS");
//		} else {
//			model.addAttribute("formTitle", "Edit FRS");
//		}
//
//		return "FRS/formFRS";
//	}
//
	@RequestMapping(value="/FRS/{id}", method=RequestMethod.GET)
	public String createFRS(Model model, @PathVariable("id") Integer id, @ModelAttribute("frsf") @Validated FRSForm frsf) {

//		FRSForm frsf = new FRSForm();
//		frsf.setSemesters(smt);
		
//		System.out.println(frsf.getSemesters());
		
		Student mhs = studentDAO.findStudentById(id);
		
//		System.out.println(mhs.getNama());
		
		if(mhs.getStatus() != Status.AKTIF) {
			model.addAttribute("status", mhs.getStatus());
			return"Errors/FRSError1";
		}

		return this.formFRS(model, frsf, mhs);
	}
//
	@RequestMapping(value="/PRS/{id}", method=RequestMethod.GET)
	public String editFRS(Model model, @PathVariable("id") Integer id) {
		FRSForm frsf = null;
		Student mahasiswa = null;
		if (id != null) {

			FRS frs = frsDAO.getFRSbyId(id);

			frsf = new FRSForm();
			frsf.setId(frs.getId());
			frsf.setNPM(frs.getMhs().getId());
//			frsf.setId_MK(frs.getMk().getId_MK());
			frsf.setDosenWali(frs.getDosenWali());
			frsf.setSemesters(frs.getNumSemester());
			frsf.setSemester(frs.getSemester());

			mahasiswa = studentDAO.findStudentById(frs.getMhs().getId());

		}
		if (frsf == null) {
			return "redirect:/FRSs";
		}

		return this.formPRS(model, frsf, mahasiswa);
	}
//
	@RequestMapping(value="/deleteFRS/{id}",  method=RequestMethod.GET)
	public String deleteFRS(Model model, @PathVariable("id") Integer id) {
		frsDAO.deleteFRS(id);
		return "redirect:/FRSs";
	}

	@RequestMapping(value = "/FRS", method = RequestMethod.POST)
	public String saveFRS(Model model, @ModelAttribute("frsForm") FRSForm frsf, @RequestParam("choose_mk") Integer[] chooseMk) {
		frsDAO.saveFRS(frsf,chooseMk);
		return "redirect:/FRSs";
	}
	
	
	@RequestMapping(value = "/PRS", method = RequestMethod.POST)
	public String savePRS(Model model, @ModelAttribute("frsForm") FRSForm frsf, @RequestParam("choose_mk") Integer[] chooseMk) {
		frsDAO.savePRS(frsf,chooseMk);
		return "redirect:/FRSs";
	}
	
	@RequestMapping(value="/viewDetail/{id}", method=RequestMethod.GET)
	public String viewFRSDetail(Model model,@PathVariable("id")Integer frs_id) {
		List<FRSDetail> frsDetail=this.frsDetailDAO.getAllDetailFromFRSId(frs_id);
		FRS frs= frsDAO.getFRSbyId(frs_id);
		model.addAttribute("mahasiswa",frs.getMhs().getNama());
		model.addAttribute("semester",frs.getSemester());
		model.addAttribute("dosen", frs.getDosenWali());
		model.addAttribute("frsDetailInfo",frsDetail);
		return "FRS/frsDetails";
	}
	
	@RequestMapping(value="/preCreateFRS/{id}" , method = RequestMethod.GET)
	public String preCreateFRS(Model model, @PathVariable("id") Integer id) {
		FRSForm frsf=new FRSForm();
		model.addAttribute("frsf",frsf);
		model.addAttribute("FRSid", id);
		return "FRS/preCreateFRS";
	}
	
	public List<SubjectMajor> filterSubjectBySemester(List<SubjectMajor> mkjList, Semester smt){
		List<SubjectMajor> res= new ArrayList<>();
//		System.out.println(smt);
		
		for(Integer i=0;i<mkjList.size();i++) {
			SubjectMajor temp=mkjList.get(i);
//			System.out.println(temp.getMk().getSemester());
			Semester temp1=temp.getMk().getSemester();
			if(temp1==smt) {
//				System.out.println(temp.getMk().getNama_MK());
				res.add(temp);
			}
		}
		
//		System.out.println(res.isEmpty());
		
//		for(SubjectMajor temp : res) {
//			System.out.println(temp.getMk().getNama_MK());
//		}
		
		return res;
	}

}
