package com.excercise.college.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.excercise.college.dao.MajorDAO;
import com.excercise.college.models.Major;

public class MajorDAOImpl implements MajorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	//Method untuk mengambil data semua jurusan yang ada
	//Dari tabel "Majors" pada basis data
	//Mengembalikan List jurusan yang ada
	@Override
	public List<Major> listAllMajor() {
		String sql = "Select new " + Major.class.getName()
				+ "(a.idJurusan, a.namaJurusan,a.fakultasJurusan,a.kepalaJurusan,a.code) " + " from " + Major.class.getName()
				+ " a " + "ORDER BY a.idJurusan DESC";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		return query.list();
	}

	//Method untuk mengambil data jurusan sesuai Id jurusan yang diminta
	//Mengembalikan jurusan dengan Id yang dimaksud
	@Override
	public Major getMajorById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Major.class);
		crit.add(Restrictions.eq("idJurusan", id));
		return (Major) crit.uniqueResult();
	}

	//Method untuk menghapus data jurusan dengan Id yang diminta
	@Override
	public void deleteMajor(Integer id) {
		Major maj = this.getMajorById(id);
		if (maj != null) {
			this.sessionFactory.getCurrentSession().delete(maj);
		}

	}

	//Method untuk menyimpan data jurusan yang dibuat atau di-edit
	//Data dari form akan diambil dan akan dimasukan ke dalam tabel...
	//..Majors pada basis data
	@Override
	public void saveMajor(Major jurusan) {
		Integer id = jurusan.getIdJurusan();
		Major jur = null;
		if (id != null) {
			jur = this.getMajorById(id);
		}

		boolean isNew = false;
		if (jur == null) {
			isNew = true;
			jur = new Major();
		}

		jur.setNamaJurusan(jurusan.getNamaJurusan());
		jur.setFakultasJurusan(jurusan.getFakultasJurusan());
		jur.setKepalaJurusan(jurusan.getKepalaJurusan());
		jur.setCode(jurusan.getCode());

		if (isNew) {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(jur);
		}
	}

}
