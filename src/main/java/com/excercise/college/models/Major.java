package com.excercise.college.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Majors")
public class Major {
	private Integer id;
	private String name;
	private String faculty;
	private String head;
	private Integer code;

	public Major() {

	}

	public Major(Integer idJurusan, String namaJurusan, String fakultasJurusan, String kepalaJurusan, Integer code) {
		this.id = idJurusan;
		this.name = namaJurusan;
		this.faculty = fakultasJurusan;
		this.head = kepalaJurusan;
		this.code=code;
	}

	// private List<Mahasiswa> mhsList;
	//
	// public List<Mahasiswa> getMhsList() {
	// return mhsList;
	// }
	// public void setMhsList(List<Mahasiswa> mhsList) {
	// this.mhsList = mhsList;
	// }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public Integer getIdJurusan() {
		return id;
	}

	public void setIdJurusan(Integer idJurusan) {
		this.id = idJurusan;
	}

	@Column(name = "name", length = 50, nullable = false)
	public String getNamaJurusan() {
		return name;
	}

	public void setNamaJurusan(String namaJurusan) {
		this.name = namaJurusan;
	}

	@Column(name = "faculty", length = 50, nullable = false)
	public String getFakultasJurusan() {
		return faculty;
	}

	public void setFakultasJurusan(String fakultasJurusan) {
		this.faculty = fakultasJurusan;
	}

	@Column(name = "head", length = 50, nullable = false)
	public String getKepalaJurusan() {
		return head;
	}

	public void setKepalaJurusan(String kepalaJurusan) {
		this.head = kepalaJurusan;
	}

	@Column(name="code", nullable=false)
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
