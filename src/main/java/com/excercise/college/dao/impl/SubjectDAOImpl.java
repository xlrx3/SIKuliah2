package com.excercise.college.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.excercise.college.dao.SubjectDAO;
import com.excercise.college.models.Subject;

public class SubjectDAOImpl implements SubjectDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Subject getSubjectById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Subject.class);
		crit.add(Restrictions.eq("id_MK", id));
		return (Subject) crit.uniqueResult();
	}

	@Override
	public List<Subject> getAllSubjects() {
		String sql = "Select new " + Subject.class.getName() + "(a.id_MK, a.nama_MK,a.SKS,a.semester) " + " from "
				+ Subject.class.getName() + " a " + "ORDER BY a.id_MK DESC";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		return query.list();
	}

	@Override
	public void deleteSubject(Integer id) {
		Subject mk = this.getSubjectById(id);

		if (mk != null) {
			this.sessionFactory.getCurrentSession().delete(mk);
		}

	}

	@Override
	public void saveSubject(Subject matkul) {
		Integer id = matkul.getId_MK();
		Subject mk = null;
		if (id != null) {

			mk = this.getSubjectById(id);
		}

		boolean isNew = false;
		if (mk == null) {
			isNew = true;
			mk = new Subject();
		}

		mk.setNama_MK(matkul.getNama_MK());
		mk.setSKS(matkul.getSKS());
		mk.setSemester(matkul.getSemester());
		if (isNew) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(mk);
		}

	}

}
