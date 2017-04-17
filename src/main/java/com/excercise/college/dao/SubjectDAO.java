package com.excercise.college.dao;

import java.util.List;

import com.excercise.college.models.Subject;

public interface SubjectDAO {
	public Subject getSubjectById(Integer id);

	public List<Subject> getAllSubjects();

	public void deleteSubject(Integer id);

	public void saveSubject(Subject mk);
	
}
