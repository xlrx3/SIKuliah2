package com.excercise.college.dao;

import java.util.List;

import com.excercise.college.models.FRSDetail;
import com.excercise.college.models.Subject;

public interface FRSDetailDAO {

	public List<FRSDetail> listAllFRSDetail();
	
	public FRSDetail getFRSDetailById(Integer Id);
	
	public List<FRSDetail> getAllDetailFromFRSId(Integer frs_id);
	
	public void saveFRSDetailForFRSId(Integer frs_id, Integer[] idMK);
	
	public void deleteSubjectFromFRSDetail(Integer frs_id);
	
	
}
