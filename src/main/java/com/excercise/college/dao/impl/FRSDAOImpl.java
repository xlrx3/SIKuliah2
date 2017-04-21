package com.excercise.college.dao.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.excercise.college.dao.FRSDAO;
import com.excercise.college.dao.FRSDetailDAO;
import com.excercise.college.dao.StudentDAO;
import com.excercise.college.dao.SubjectDAO;
import com.excercise.college.enums.Semester;
import com.excercise.college.forms.FRSForm;
import com.excercise.college.models.FRS;
import com.excercise.college.models.Student;
import com.excercise.college.models.Subject;

public class FRSDAOImpl implements FRSDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private SubjectDAO subjectDAO;
	
	@Autowired
	private FRSDetailDAO frsDetailDAO;

	//Method untuk mengambil semua data FRS yang pernah dilakukan
	//Mengembalikan List berisi semua data FRS yang pernah dilakukan
	@Override
	public List<Object[]> listAllFRS() {
		Session session=sessionFactory.getCurrentSession();
//		Criteria criteria = session.createCriteria(FRS.class, "frs");
//		criteria.createAlias("frs.mhs", "student");
//		criteria.addOrder(Order.desc("id"));
		String sql= "select f.id, s.nama, sum(sbj.SKS), f.tanggal, f.dosenWali, f.semester, f.status "
				+ "from Student s, Subject sbj, FRS f, FRSDetail fd "
				+ "where fd.frs = f.id and fd.mk = sbj.id and f.mhs= s.id "
				+"group by (f.id, s.nama, f.tanggal, f.dosenWali, f.semester, f.status) " 
				+ "order by f.id DESC";
		
		Query query = session.createQuery(sql);
		List<Object[]>list= query.list();
		return list;
	}
	
	//Method untuk mengambil data FRS yang pernah dilakukan
	// Dengan Id FRS tertentu
	//Mengembalikan data FRS dengan Id yang dimaksud
	@Override
	public FRS getFRSbyId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(FRS.class);
		crit.add(Restrictions.eq("id", id));
		return (FRS)crit.uniqueResult();
	}
	
	//Method untuk menghapus data FRS yang pernah dilakukan
	//Akan menghapus data FRS dengan Id yang ditentukan
	@Override
	public void deleteFRS(Integer id) {
		if (id != null) {
			Session session = sessionFactory.getCurrentSession();

			FRS frs = this.getFRSbyId(id);
			

			if (frs != null) {
				this.frsDetailDAO.deleteSubjectFromFRSDetail(frs.getId());
				this.sessionFactory.getCurrentSession().delete(frs);
			}
		}
		
	}
	
	//Method untuk melakukan penyimpanan data FRS saat melakukan FRS
	//Data yang diambil dari FRSForm kemudian akan disimpan ke tabel...
	//...FRS di basis data
	@Override
	public void saveFRS(FRSForm frsf,Integer[] chooseMK) {
		Integer id = frsf.getId();
		FRS frs = new FRS();

		System.out.println(id);
		Session session = this.sessionFactory.getCurrentSession();

		System.out.println(frsf.getNPM());
		Student mhs =studentDAO.findStudentById(frsf.getNPM()) ;
//		Subject mk = subjectDAO.getSubjectById(frsf.getId_MK());

//		if (id != null) {
//			frs = this.getFRSbyId(id);
//		}

		LocalDate localDate = LocalDate.now();
		Date sqlDate = java.sql.Date.valueOf(localDate);

		System.out.println(mhs.getNPM());
		System.out.println(frsf.getSemesters());

		frs.setDosenWali(frsf.getDosenWali());
		frs.setMhs(mhs);
		frs.setStatus(true);
		frs.setTanggal(sqlDate);
		frs.setNumSemester(frsf.getSemesters());
		frs.setSemester(frsf.getSemester());
		session.persist(frs);
		this.frsDetailDAO.saveFRSDetailForFRSId(frs.getId(), chooseMK);
	}

	@Override
	public void savePRS(FRSForm frsf, Integer[] chooseMK) {
		Integer id = frsf.getId();
		FRS frs = this.getFRSbyId(frsf.getId());

		Session session = this.sessionFactory.getCurrentSession();

		Student mhs =studentDAO.findStudentById(frsf.getNPM()) ;
//		Subject mk = subjectDAO.getSubjectById(frsf.getId_MK());

//		if (id != null) {
//			frs = this.getFRSbyId(id);
//		}

		LocalDate localDate = LocalDate.now();
		Date sqlDate = java.sql.Date.valueOf(localDate);

		System.out.println(mhs.getNPM());
		System.out.println(frsf.getSemesters());

		frs.setDosenWali(frsf.getDosenWali());
		frs.setMhs(mhs);
		frs.setStatus(true);
//		frs.setTanggal(sqlDate);
		frs.setNumSemester(frsf.getSemesters());
		frs.setSemester(frsf.getSemester());
		session.persist(frs);
		this.frsDetailDAO.deleteSubjectFromFRSDetail(frs.getId());
		this.frsDetailDAO.saveFRSDetailForFRSId(frs.getId(), chooseMK);
		
	}

//	@Override
//	public List<FRS> getFRSByStudentName(String Name) {
//		Session ses= sessionFactory.getCurrentSession();
//		Criteria crit= ses.createCriteria(FRS.class,"frs");
//		crit.createAlias("frs.mhs", "student");
//		crit.add(Restrictions.eq("frs.mhs.nama",Name));
//		return crit.list();
//	}


}
