package com.excercise.college.dao;

import java.util.List;

public interface ReportDAO {

	public List<Object[]> getMajorsWithMostSubject();
	public List<Object[]> getStudentsWithMostSubjects();
	public List<Object[]> getSubjectsWithMostStudents();
	
}
