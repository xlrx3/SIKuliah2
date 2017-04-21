package com.excercise.college.models;

import java.sql.Date;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.type.EnumType;

import com.excercise.college.enums.Semester;

@Entity
@Table(name = "FRS")
public class FRS {
	private Integer id;
	private Student mhs;
//	private Subject mk;
	private Date tanggal;
	private String dosenWali;
	private boolean status;
	private Semester semester;
	private Integer numSemester;

	@Column(name = "numSemester", nullable = false)
	public Integer getNumSemester() {
		return numSemester;
	}

	public void setNumSemester(Integer numSemester) {
		this.numSemester = numSemester;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFRS", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "mhs_npm", nullable = false, //
			foreignKey = @ForeignKey(name = "FRS_ibfk_1"))
	public Student getMhs() {
		return mhs;
	}

	public void setMhs(Student mhs) {
		this.mhs = mhs;
	}

//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//	@JoinColumn(name = "mk_id", nullable = false, //
//			foreignKey = @ForeignKey(name = "FRS_ibfk_2"))
//	public Subject getMk() {
//		return mk;
//	}
//
//	public void setMk(Subject mk) {
//		this.mk = mk;
//	}

	@Column(name = "FRSDate", length = 80)
	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	@Column(name = "dosenWali", length = 50, nullable = false)
	public String getDosenWali() {
		return dosenWali;
	}

	public void setDosenWali(String dosenWali) {
		this.dosenWali = dosenWali;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Column(name = "FRSSemester", nullable = false)
	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	
	
	

}
