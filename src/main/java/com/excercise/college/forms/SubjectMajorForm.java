package com.excercise.college.forms;

public class SubjectMajorForm {
	private Integer id;
	private Integer id_MK;
	private Integer id_jur;
	private String nama_MK;
	private String nama_jur;

	public SubjectMajorForm() {

	}

	public SubjectMajorForm(Integer id, Integer id_MK, Integer id_jur, String nama_MK, String nama_jur) {
		this.id = id;
		this.id_MK = id_MK;
		this.id_jur = id_jur;
		this.nama_MK = nama_MK;
		this.nama_jur = nama_jur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_MK() {
		return id_MK;
	}

	public void setId_MK(Integer id_MK) {
		this.id_MK = id_MK;
	}

	public Integer getId_jur() {
		return id_jur;
	}

	public void setId_jur(Integer id_jur) {
		this.id_jur = id_jur;
	}

	public String getNama_MK() {
		return nama_MK;
	}

	public void setNama_MK(String nama_MK) {
		this.nama_MK = nama_MK;
	}

	public String getNama_jur() {
		return nama_jur;
	}

	public void setNama_jur(String nama_jur) {
		this.nama_jur = nama_jur;
	}

}
