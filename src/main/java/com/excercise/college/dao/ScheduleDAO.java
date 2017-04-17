package com.excercise.college.dao;

import java.util.List;

import com.excercise.college.forms.ScheduleForm;
import com.excercise.college.models.Schedule;

public interface ScheduleDAO {
	public List<Schedule> listAllSchedule();
	public Schedule getScheduleById(Integer id);
	public void deleteSchedule(Integer id);
	public void saveSchedule(ScheduleForm jadwal);
}
