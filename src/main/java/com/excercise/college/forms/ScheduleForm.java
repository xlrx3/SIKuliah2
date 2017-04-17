package com.excercise.college.forms;

import com.excercise.college.enums.Days;
import com.excercise.college.models.Subject;

public class ScheduleForm {
	private Integer id;
	private String ruangan;
	private Days hari;
	private String jam_mulai;
	private String jam_selesai;
	private Integer idMK;

	public ScheduleForm() {

	}

	public ScheduleForm(Integer id, String ruangan, Days hari, String jam_mulai, String jam_selesai, Integer idMK) {
		this.id = id;
		this.ruangan = ruangan;
		this.hari = hari;
		this.jam_mulai = jam_mulai;
		this.jam_selesai = jam_selesai;
		this.idMK = idMK;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer idJ) {
		this.id = idJ;
	}

	public String getRuangan() {
		return ruangan;
	}

	public void setRuangan(String ruangan) {
		this.ruangan = ruangan;
	}

	public Days getHari() {
		return hari;
	}

	public void setHari(Days hari) {
		this.hari = hari;
	}

	public String getJam_mulai() {
		return jam_mulai;
	}

	public void setJam_mulai(String jam_mulai) {
		this.jam_mulai = jam_mulai;
	}

	public String getJam_selesai() {
		return jam_selesai;
	}

	public void setJam_selesai(String jam_selesai) {
		this.jam_selesai = jam_selesai;
	}

	public Integer getIdMK() {
		return idMK;
	}

	public void setIdMK(Integer idMK) {
		this.idMK = idMK;
	}

}
