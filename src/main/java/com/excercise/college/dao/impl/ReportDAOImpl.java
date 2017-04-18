package com.excercise.college.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import com.excercise.college.dao.ReportDAO;
import com.excercise.college.models.FRS;
import com.excercise.college.models.FRSDetail;
import com.excercise.college.models.SubjectMajor;

public class ReportDAOImpl implements ReportDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	//Untuk mendapatkan jurusan yang punya mata kuliah terbanyak
	
	@Override
	public List<Object[]> getMajorsWithMostSubject() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SubjectMajor.class, "mkj");
		criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("jurusan"))
				.add(Projections.count("mk"), "mkCount")).addOrder(Order.desc("mkCount"));
		criteria.setMaxResults(1);

		return criteria.list();
	}

	
	//Untuk mendapatkan Mahasiswa yang mengambil mata kuliah terbanyak
	
	@Override
	public List<Object[]> getStudentsWithMostSubjects() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FRSDetail.class, "frsd");
		criteria.createAlias("frsd.frs", "frs");
		criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("frs.mhs"))
				.add(Projections.count("frsd.mk"), "mkCount")).addOrder(Order.desc("mkCount"));
		criteria.setMaxResults(5);
		
		return criteria.list();
	}

	
	//Untuk mendapatkan report Mata Kuliah dengan mahasiswa terbanyak
	
	@Override
	public List<Object[]> getSubjectsWithMostStudents() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FRSDetail.class, "frsd");
		criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("mk"))
				.add(Projections.count("frs"), "frsCount")).addOrder(Order.desc("frsCount"));
		criteria.setMaxResults(3);
		
		return criteria.list();
	}

}
