package com.excercise.college.dao;

import java.util.List;

import com.excercise.college.forms.FRSForm;
import com.excercise.college.models.FRS;

public interface FRSDAO {
	public List<Object[]> listAllFRS();
	public FRS getFRSbyId(Integer id);
	public void deleteFRS(Integer id);
	public void saveFRS(FRSForm frs,Integer[] chooseMK);
	public void savePRS(FRSForm frs,Integer[] chooseMK);
//	public List<FRS> getFRSByStudentName(String Name);
}
