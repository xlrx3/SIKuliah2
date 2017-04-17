package com.excercise.college.dao;

import java.util.List;

import com.excercise.college.enums.Semester;
import com.excercise.college.forms.SubjectMajorForm;
import com.excercise.college.models.FRSDetail;
import com.excercise.college.models.SubjectMajor;


public interface SubjectMajorDAO {
	public List<SubjectMajor> listAllSubjectMajor();
	public SubjectMajor getSubjectMajorbyId(Integer id);
	public void deleteSubjectMajor(Integer id);
	public void saveSubjectMajor(SubjectMajorForm mkj);
	public List<SubjectMajor> listAllSubjectMajorByMajors(Integer idMajor);
	public List<SubjectMajor> listAllUniqueSubject(List<FRSDetail> frsd, Integer idMajor, Semester smt);
}
