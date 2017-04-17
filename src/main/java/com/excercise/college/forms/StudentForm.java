package com.excercise.college.forms;

import com.excercise.college.enums.Status;

public class StudentForm {
	private Integer id;
	private Integer NPM;
	private String nama;
	private Integer angkatan;
	private Status status;
	private Integer idJur;

	public StudentForm() {

	}

	public StudentForm(Integer id, Integer nPM, String nama, Integer angkatan, Status status, Integer idJur) {
		this.id = id;
		this.NPM = nPM;
		this.nama = nama;
		this.angkatan = angkatan;
		this.status = status;
		this.idJur = idJur;
	}

	public Integer getNPM() {
		return NPM;
	}

	public void setNPM(Integer nPM) {
		this.NPM = nPM;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Integer getAngkatan() {
		return angkatan;
	}

	public void setAngkatan(Integer angkatan) {
		this.angkatan = angkatan;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getIdJur() {
		return idJur;
	}

	public void setIdJur(Integer idJur) {
		this.idJur = idJur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
