package com.excercise.college.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.excercise.college.dao.FRSDAO;
import com.excercise.college.dao.FRSDetailDAO;
import com.excercise.college.dao.StudentDAO;
import com.excercise.college.dao.SubjectDAO;
import com.excercise.college.models.FRS;
import com.excercise.college.models.FRSDetail;
import com.excercise.college.models.Major;
import com.excercise.college.models.Subject;

public class FRSDetailDAOImpl implements FRSDetailDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private SubjectDAO subjectDAO;
	
	@Autowired
	private FRSDAO frsDAO;

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public List<FRSDetail> listAllFRSDetail() {
		Session session= this.sessionFactory.getCurrentSession();
		Criteria crit= session.createCriteria(FRSDetail.class,"frsD");
		crit.createAlias("frsD.frs", "FRS");
		crit.createAlias("frsD.mk", "subject");
		return crit.list();
	}

	@Override
	public List<FRSDetail> getAllDetailFromFRSId(Integer frs_id) {
		Session session= this.sessionFactory.getCurrentSession();
		Criteria crit= session.createCriteria(FRSDetail.class,"frsD");
		crit.createAlias("frsD.frs", "FRS");
		crit.createAlias("frsD.mk", "subject");
		crit.add(Restrictions.eq("frsD.frs.id", frs_id));
		return crit.list();
	}

	@Override
	public void saveFRSDetailForFRSId(Integer frs_id, Integer[] idMK) {
		for (int i = 0; i < idMK.length; i++) {
			Session session = sessionFactory.getCurrentSession();
			FRSDetail frsDetail = new FRSDetail();
			Subject mk = subjectDAO.getSubjectById(idMK[i]);
//			System.out.println("nama mk = " + mk.getSubjectName());
//			System.out.println("id mk = " + mk.getId());

			FRS frs =frsDAO.getFRSbyId(frs_id);
			frsDetail.setMk(mk);
			frsDetail.setFrs(frs);
			frsDetail.setSks(mk.getSKS());
			session.persist(frsDetail);
		}
		
	}

	@Override
	public void deleteSubjectFromFRSDetail(Integer frs_id) {
		Session session= sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM FRSDetail WHERE frs="+frs_id ).executeUpdate();
	}

	@Override
	public FRSDetail getFRSDetailById(Integer Id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(FRSDetail.class);
		crit.add(Restrictions.eq("id", Id));
		return (FRSDetail) crit.uniqueResult();

	}

}
