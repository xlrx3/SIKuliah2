package com.excercise.college.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.excercise.college.dao.MajorDAO;
import com.excercise.college.dao.StudentDAO;
import com.excercise.college.forms.StudentForm;
import com.excercise.college.models.Major;
import com.excercise.college.models.Student;

public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private MajorDAO majorDAO;

	@Override
	public Student findStudentById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Student.class);
		crit.add(Restrictions.eq("id", id));
		return (Student) crit.uniqueResult();
	}

	@Override
	public List<Student> listAllStudents() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Student.class, "students");
		criteria.createAlias("students.jurusan", "major");
		criteria.addOrder(Order.asc("major.code"));
		criteria.addOrder(Order.asc("angkatan"));
		criteria.addOrder(Order.desc("id"));
		List<Student> std = criteria.list();
		return std;
	}

	@Override
	public void saveStudent(StudentForm mahasiswa) {
		Integer id = mahasiswa.getId();
		Integer angkatan = mahasiswa.getAngkatan();
		Student mhs = null;
		Major jur = majorDAO.getMajorById(mahasiswa.getIdJur());
		if (id != null) {
		mhs = this.findStudentById(id);
		
		Integer angs=mhs.getAngkatan();
		
		System.out.println(angs);
		System.out.println(angkatan);
		System.out.println(mhs.getJurusan().getIdJurusan());
		System.out.println(mahasiswa.getIdJur());
		
		if(!angs.equals(angkatan) || mhs.getJurusan().getIdJurusan() != mahasiswa.getIdJur()) {
			mhs.setNPM((mahasiswa.getAngkatan()*1000000)+(jur.getCode()*10000)+this.countStudentByMajorByYear(jur,mahasiswa.getAngkatan()));
		}
			
			
			else {
				System.out.println("is");
			}
		}

		boolean isNew = false;
		if (mhs == null) {
			isNew = true;
			mhs = new Student();
		}

		// System.out.println(mahasiswa.getNama());
		mhs.setJurusan(jur);
//		mhs.setNPM(mahasiswa.getNPM());
		mhs.setNama(mahasiswa.getNama());
		mhs.setAngkatan(mahasiswa.getAngkatan());
		mhs.setStatus(mahasiswa.getStatus());
		

		// mhs.setJurusan();
		// System.out.println(mahasiswa.getJurusan().getNamaJurusan());

		if (isNew) {
			Session session = this.sessionFactory.getCurrentSession();
			mhs.setNPM((mahasiswa.getAngkatan()*1000000)+(jur.getCode()*10000)+this.countStudentByMajorByYear(jur,mahasiswa.getAngkatan()));
			session.persist(mhs);
		}

	}

	@Override
	public StudentForm findStudentFormById(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Criteria crit=session.createCriteria(StudentForm.class);
		crit.add(Restrictions.eq("id",id));
		return null;
	}

	@Override
	public void deleteStudent(Integer id) {
		Session session = sessionFactory.getCurrentSession();

		Criteria crit = session.createCriteria(Student.class);
		crit.add(Restrictions.eq("id", id));

		Student mhs = (Student) crit.uniqueResult();
		if (mhs != null) {
			this.sessionFactory.getCurrentSession().delete(mhs);
		}

	}

	@Override
	public Integer countStudentByMajorByYear(Major jur, Integer angkatan) {
		Session session= sessionFactory.getCurrentSession();
		Criteria crit= session.createCriteria(Student.class);
		crit.add(Restrictions.eq("jurusan", jur));
		crit.add(Restrictions.eq("angkatan", angkatan));
		System.out.println(crit.setProjection(Projections.count("NPM")).uniqueResult());
		Long temp=(Long)crit.setProjection(Projections.count("NPM")).uniqueResult();
		Integer res = temp != null ? temp.intValue() : null;
		return res+1;
	}

	@Override
	public List<Student> getStudentThatMajors(Integer majorId) {
		Major jur=majorDAO.getMajorById(majorId);
		Session session= sessionFactory.getCurrentSession();
		Criteria crit= session.createCriteria(Student.class);
		crit.createAlias("jurusan", "major");
		crit.add(Restrictions.eq("major.id", jur.getIdJurusan()));
		return crit.list();
	}

}
