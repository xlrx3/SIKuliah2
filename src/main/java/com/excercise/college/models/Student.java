package com.excercise.college.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.excercise.college.enums.Status;

@Entity
@Table(name = "Students")
public class Student implements Serializable {
	private static final long serialVersionUID = -7893237204476214050L;
	private Integer id;
	private Integer NPM;
	private String nama;
	private Integer angkatan;
	private Status status;
	private Major jurusan;

	private List<Major> jurusanInfos;

	public Student() {

	}

	public Student(Integer nPM, String nama, Integer angkatan, Status status, Major jurusan) {
		NPM = nPM;
		this.nama = nama;
		this.angkatan = angkatan;
		this.status = status;
		this.jurusan = jurusan;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "npm", nullable = false)
	public Integer getNPM() {
		return NPM;
	}

	public void setNPM(Integer nPM) {
		NPM = nPM;
	}

	@Column(name = "name", length = 50, nullable = false)
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	@Column(name = "angkatan", nullable = false)
	public Integer getAngkatan() {
		return angkatan;
	}

	public void setAngkatan(Integer angkatan) {
		this.angkatan = angkatan;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idJurusan", nullable = false, //
			foreignKey = @ForeignKey(name = "Mahasiswa_ibfk_1"))
	public Major getJurusan() {
		return jurusan;
	}

	public void setJurusan(Major jurusan) {
		this.jurusan = jurusan;
	}

}
