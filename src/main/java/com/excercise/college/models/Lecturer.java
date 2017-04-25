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

import com.excercise.college.enums.Position;

@Entity
@Table(name = "Lecturers")
public class Lecturer implements Serializable {
	private static final long serialVersionUID = -7893237204476214050L;
	private Integer id;
	private Integer NID;
	private String nama;
	private Position jabatan;
	private Major jurusan;
	
	public Lecturer() {
		
	}
	
	public Lecturer(Integer id, Integer nID, String nama, Position jabatan, Major jurusan) {
		this.id = id;
		NID = nID;
		this.nama = nama;
		this.jabatan = jabatan;
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

	@Column(name = "NID", nullable = false)
	public Integer getNID() {
		return NID;
	}

	public void setNID(Integer nID) {
		NID = nID;
	}

	@Column(name = "namaDosen", length=100, nullable = false)
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	@Enumerated(EnumType.ORDINAL)
	@Column(name="Position", nullable=false)
	public Position getJabatan() {
		return jabatan;
	}

	public void setJabatan(Position jabatan) {
		this.jabatan = jabatan;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Jurusan", nullable = false, //
			foreignKey = @ForeignKey(name = "Lecturer_ibfk_1"))
	public Major getJurusan() {
		return jurusan;
	}

	public void setJurusan(Major jurusan) {
		this.jurusan = jurusan;
	}
	
	

}
