package com.excercise.college.dao;

import com.excercise.college.forms.LecturerForm;
import com.excercise.college.models.Lecturer;
import java.util.List;

public interface LecturerDAO {
public List<Lecturer> getAllLecturer();
public Lecturer getLecturerById(Integer id);
public void deleteLecturer(Integer id);
public void saveLecturer(LecturerForm lf);

}
