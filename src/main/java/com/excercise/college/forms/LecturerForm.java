package com.excercise.college.forms;

import com.excercise.college.enums.Position;
import com.excercise.college.models.Major;

public class LecturerForm {
	private Integer id;
	private Integer NID;
	private String nama;
	private Position jabatan;
	private Major jurusan;
	
	public LecturerForm() {
		
	}

	public LecturerForm(Integer id, Integer nID, String nama, Position jabatan, Major jurusan) {
		this.id = id;
		NID = nID;
		this.nama = nama;
		this.jabatan = jabatan;
		this.jurusan = jurusan;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNID() {
		return NID;
	}

	public void setNID(Integer nID) {
		NID = nID;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Position getJabatan() {
		return jabatan;
	}

	public void setJabatan(Position jabatan) {
		this.jabatan = jabatan;
	}

	public Major getJurusan() {
		return jurusan;
	}

	public void setJurusan(Major jurusan) {
		this.jurusan = jurusan;
	}
	
	
	
	
}
