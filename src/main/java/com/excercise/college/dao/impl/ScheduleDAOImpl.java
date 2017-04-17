package com.excercise.college.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.excercise.college.dao.ScheduleDAO;
import com.excercise.college.dao.SubjectDAO;
import com.excercise.college.forms.ScheduleForm;
import com.excercise.college.models.Schedule;
import com.excercise.college.models.Subject;

public class ScheduleDAOImpl implements ScheduleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private SubjectDAO subjectDAO;
	
	@Override
	public List<Schedule> listAllSchedule() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Schedule.class, "jadwal");
		criteria.createAlias("jadwal.mk", "subject");
		criteria.addOrder(Order.desc("id"));
		return criteria.list();
	}

	@Override
	public Schedule getScheduleById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Schedule.class);
		crit.add(Restrictions.eq("id", id));
		return (Schedule)crit.uniqueResult();
	}

	@Override
	public void deleteSchedule(Integer id) {
		if (id != null) {
			Session session = sessionFactory.getCurrentSession();

			Schedule jad = this.getScheduleById(id);
			if (jad != null) {
				this.sessionFactory.getCurrentSession().delete(jad);
			}
		}
		
	}

	@Override
	public void saveSchedule(ScheduleForm jadwal) {
		Integer id = jadwal.getId();
		Schedule jad = null;

		if (id != null) {

			jad = this.getScheduleById(id);

			Subject mk = subjectDAO.getSubjectById(jadwal.getIdMK());
			// Hibernate.initialize(jur);

			jad.setMk(mk);

		}

		boolean isNew = false;
		if (jad == null) {
			isNew = true;
			jad = new Schedule();
		}

		// System.out.println(mahasiswa.getNama());
		jad.setHari(jadwal.getHari());
		jad.setRuangan(jadwal.getRuangan());
		jad.setJam_mulai(jadwal.getJam_mulai());
		jad.setJam_selesai(jadwal.getJam_selesai());
		// mhs.setJurusan();
		// System.out.println(mahasiswa.getJurusan().getNamaJurusan());

		if (isNew) {
			Session session = this.sessionFactory.getCurrentSession();


			Subject mk = subjectDAO.getSubjectById(jadwal.getIdMK());
			// Hibernate.initialize(jur);

			// System.out.println(mk.getId_MK()+"aaaa");
			jad.setMk(mk);

			session.persist(jad);
		}
		
	}

}
