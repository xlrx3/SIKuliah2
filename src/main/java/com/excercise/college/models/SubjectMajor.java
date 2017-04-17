package com.excercise.college.models;

import java.io.Serializable;
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
@Table(name = "MK_Jurusan")
public class SubjectMajor {
	private Integer id;
	private Major jurusan;
	private Subject mk;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMKJur", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_mk", nullable = false, //
			foreignKey = @ForeignKey(name = "MK_Jur_ibfk_1"))
	public Subject getMk() {
		return mk;
	}

	public void setMk(Subject mk) {
		this.mk = mk;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_jur", nullable = false, //
			foreignKey = @ForeignKey(name = "MK_Jur_ibfk_2"))
	public Major getJurusan() {
		return jurusan;
	}

	public void setJurusan(Major jurusan) {
		this.jurusan = jurusan;
	}

}
