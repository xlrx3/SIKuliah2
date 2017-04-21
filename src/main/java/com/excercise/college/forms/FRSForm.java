package com.excercise.college.forms;

import java.sql.Date;

import com.excercise.college.enums.Semester;

public class FRSForm {
	private Integer id;
	private String dosenWali;
	private Integer NPM;
//	private Integer id_MK;
	private String nama_mhs;
	private String nama_jur;
	private Integer semesters;
	private Semester semester;

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public FRSForm() {

	}

	public FRSForm(Integer id, String dosenWali, Integer nPM, String nama_mhs, String nama_jur) {
		this.id = id;
		this.dosenWali = dosenWali;
		NPM = nPM;
//		this.id_MK = id_MK;
		this.nama_mhs = nama_mhs;
		this.nama_jur = nama_jur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDosenWali() {
		return dosenWali;
	}

	public void setDosenWali(String dosenWali) {
		this.dosenWali = dosenWali;
	}

	public Integer getNPM() {
		return NPM;
	}

	public void setNPM(Integer nPM) {
		NPM = nPM;
	}

//	public Integer getId_MK() {
//		return id_MK;
//	}
//
//	public void setId_MK(Integer id_MK) {
//		this.id_MK = id_MK;
//	}

	public String getNama_mhs() {
		return nama_mhs;
	}

	public void setNama_mhs(String nama_mhs) {
		this.nama_mhs = nama_mhs;
	}

	public String getNama_jur() {
		return nama_jur;
	}

	public void setNama_jur(String nama_jur) {
		this.nama_jur = nama_jur;
	}

	public Integer getSemesters() {
		return semesters;
	}

	public void setSemesters(Integer semesters) {
		this.semesters = semesters;
	}

	public Semester getSemesterFromSemesterNum(Integer smtNum) {
		if(smtNum%2==1) {
			return Semester.GANJIL;
		}
		else {
			return Semester.GENAP;
		}
	}
	
}
