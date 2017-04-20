package com.excercise.college.dao;

import java.util.List;

import com.excercise.college.models.FRSDetail;

public interface ReportDAO {

	public List<Object[]> getMajorsWithMostSubject();
	public List<Object[]> getStudentsWithMostSubjects();
	public List<Object[]> getSubjectsWithMostStudents();
	public List<FRSDetail> getSubjectsTakenByStudent(Integer id);
	public List<Object[]> getMajorsWithMostStudent();
	public List<Object[]> getTotalCreditsPerMajor();
}
