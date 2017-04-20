package com.excercise.college.dao;

import com.excercise.college.models.Major;
import com.excercise.college.models.Student;
import com.excercise.college.forms.StudentForm;
import java.util.List;

public interface StudentDAO {

	public Student findStudentById(Integer id);

	public List<Student> listAllStudents();

	public void saveStudent(StudentForm applicantInfo);

	public StudentForm findStudentFormById(Integer id);

	public void deleteStudent(Integer id);
	
	public Integer countStudentByMajorByYear (Major jur, Integer Angkatan);
	
	public List<Student> getStudentThatMajors(Integer majorId);

}
