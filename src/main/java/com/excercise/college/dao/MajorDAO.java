package com.excercise.college.dao;

import java.util.List;

import com.excercise.college.models.Major;

public interface MajorDAO {
	public List<Major> listAllMajor();

	public Major getMajorById(Integer id);

	public void deleteMajor(Integer id);

	public void saveMajor(Major jur);
}
