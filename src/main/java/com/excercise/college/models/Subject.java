package com.excercise.college.models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.excercise.college.enums.Semester;

@Entity
@Table(name = "Subjects")
public class Subject {
	private Integer id;
	private String name;
	private Integer credits;
	private Semester Semester;

	public Subject() {

	}

	public Subject(Integer id_MK, String nama_MK, Integer sKS, Semester semester) {
		this.id = id_MK;
		this.name = nama_MK;
		credits = sKS;
		Semester = semester;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)

	public Integer getId_MK() {
		return id;
	}

	public void setId_MK(Integer id_MK) {
		this.id = id_MK;
	}

	@Column(name = "name", length = 50, nullable = false)
	public String getNama_MK() {
		return name;
	}

	public void setNama_MK(String nama_MK) {
		this.name = nama_MK;
	}

	@Column(name = "Credits", nullable = false)
	public Integer getSKS() {
		return credits;
	}

	public void setSKS(Integer sKS) {
		credits = sKS;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Semester", nullable = false)
	public Semester getSemester() {
		return Semester;
	}

	public void setSemester(Semester semester) {
		Semester = semester;
	}



}
