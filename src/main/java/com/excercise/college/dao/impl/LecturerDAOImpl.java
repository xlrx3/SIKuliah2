package com.excercise.college.dao.impl;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.excercise.college.dao.LecturerDAO;
import com.excercise.college.dao.MajorDAO;
import com.excercise.college.forms.LecturerForm;
import com.excercise.college.models.Lecturer;
import com.excercise.college.models.Major;
import com.excercise.college.models.Room;

public class LecturerDAOImpl implements LecturerDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private MajorDAO majorDAO;
	
	@Override
	public List<Lecturer> getAllLecturer() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Lecturer.class, "lecturer");
		criteria.createAlias("lecturer.jurusan", "jurusan");
		criteria.addOrder(Order.desc("id"));
		return criteria.list();
	}

	@Override
	public Lecturer getLecturerById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Lecturer.class);
		crit.add(Restrictions.eq("id", id));
		return (Lecturer) crit.uniqueResult();
	}

	@Override
	public void deleteLecturer(Integer id) {
		Session session = sessionFactory.getCurrentSession();

		Criteria crit = session.createCriteria(Lecturer.class);
		crit.add(Restrictions.eq("id", id));

		Lecturer rm = (Lecturer) crit.uniqueResult();
		if (rm != null) {
			this.sessionFactory.getCurrentSession().delete(rm);
		}
		
	}

	@Override
	public void saveLecturer(LecturerForm lf) {
		Integer id = lf.getId();
		Major jur = majorDAO.getMajorById(lf.getJurusan());
		Lecturer lec=null;
		Random random=new Random();
		Integer randNum=random.nextInt(98);
		if (id != null) {
			lec = this.getLecturerById(id);
			}

			boolean isNew = false;
			if (lec == null) {
				isNew = true;
				lec = new Lecturer();
			}
			lec.setJabatan(lf.getJabatan());
			lec.setJurusan(jur);
			lec.setNama(lf.getNama());
			lec.setNID((lec.getJurusan().getIdJurusan()*10000)+(lec.getJabatan().ordinal()*100)+randNum+1);
			
			if (isNew) {
				Session session = this.sessionFactory.getCurrentSession();
				session.persist(lec);
			}
		
	}
		

}
