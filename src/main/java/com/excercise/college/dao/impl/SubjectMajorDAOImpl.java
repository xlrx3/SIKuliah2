package com.excercise.college.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.excercise.college.dao.MajorDAO;
import com.excercise.college.dao.SubjectDAO;
import com.excercise.college.dao.SubjectMajorDAO;
import com.excercise.college.enums.Semester;
import com.excercise.college.forms.SubjectMajorForm;
import com.excercise.college.models.FRSDetail;
import com.excercise.college.models.Major;
import com.excercise.college.models.Subject;
import com.excercise.college.models.SubjectMajor;

public class SubjectMajorDAOImpl implements SubjectMajorDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private SubjectDAO subjectDAO;
	
	@Autowired
	private MajorDAO majorDAO;
	
	@Override
	public List<SubjectMajor> listAllSubjectMajor() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SubjectMajor.class, "mkj");
		criteria.createAlias("mkj.jurusan", "jurusan");
		criteria.createAlias("mkj.mk", "MataKuliah");
		criteria.addOrder(Order.asc("jurusan.id"));
		criteria.addOrder(Order.desc("id"));
		return criteria.list();
	}

	@Override
	public SubjectMajor getSubjectMajorbyId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SubjectMajor.class, "mkj");
		criteria.add(Restrictions.eq("id", id));
		return (SubjectMajor)criteria.uniqueResult();
	}

	@Override
	public void deleteSubjectMajor(Integer id) {
		if (id != null) {
			Session session = sessionFactory.getCurrentSession();

			SubjectMajor mkj = this.getSubjectMajorbyId(id);

			if (mkj != null) {
				this.sessionFactory.getCurrentSession().delete(mkj);
			}
		}
		
	}

	@Override
	public void saveSubjectMajor(SubjectMajorForm mkjf) {
		Integer id = mkjf.getId();
		SubjectMajor mkj = null;

		Session session = this.sessionFactory.getCurrentSession();

		Major jur = majorDAO.getMajorById(mkjf.getId_jur());

		Subject mk = subjectDAO.getSubjectById(mkjf.getId_MK());

		if (id == null) {
			mkj = new SubjectMajor();
		} else {
			mkj = this.getSubjectMajorbyId(id);
		}

		mkj.setJurusan(jur);
		mkj.setMk(mk);
		session.persist(mkj);
		
	}

	@Override
	public List<SubjectMajor> listAllSubjectMajorByMajors(Integer idMajor) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit1 = session.createCriteria(SubjectMajor.class, "mkj");
		crit1.add(Restrictions.eq("mkj.jurusan.idJurusan", idMajor));
		return crit1.list();
	}

	@Override
	public List<SubjectMajor> listAllUniqueSubject(List<FRSDetail> frsd, Integer idMajor, Semester smt) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit1 = session.createCriteria(SubjectMajor.class, "mkj");
		crit1.createAlias("mkj.mk","subjects");
		crit1.add(Restrictions.eq("mkj.jurusan.idJurusan", idMajor));
		crit1.add(Restrictions.eq("subjects.semester", smt));
		
		for(FRSDetail detail : frsd) {
			crit1.add(Restrictions.ne("subjects.id", detail.getMk().getId_MK()));
		}
		return crit1.list();
	}

}
