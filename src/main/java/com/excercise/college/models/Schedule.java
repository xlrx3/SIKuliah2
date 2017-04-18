package com.excercise.college.models;

import java.io.Serializable;
import java.util.List;

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

import com.excercise.college.enums.Days;

@Entity
@Table(name = "Schedules")
public class Schedule {
	private Integer id;
	private Subject mk;
	private String ruangan;
	private Days hari;
	private String jam_mulai;
	private String jam_selesai;

	public Schedule() {

	}

	public Schedule(Integer idJ, Subject mk, String ruangan, Days hari, String jam_mulai, String jam_selesai) {
		this.id = idJ;
		this.mk = mk;
		this.ruangan = ruangan;
		this.hari = hari;
		this.jam_mulai = jam_mulai;
		this.jam_selesai = jam_selesai;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idJ", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer idJ) {
		this.id = idJ;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "matakuliah", nullable = false, //
			foreignKey = @ForeignKey(name = "Jadwal_ibfk_1"))
	public Subject getMk() {
		return mk;
	}

	public void setMk(Subject mk) {
		this.mk = mk;
	}

	@Column(name = "ruangan", length = 50, nullable = false)
	public String getRuangan() {
		return ruangan;
	}

	public void setRuangan(String ruangan) {
		this.ruangan = ruangan;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "hari", length = 50, nullable = false)
	public Days getHari() {
		return hari;
	}

	public void setHari(Days hari) {
		this.hari = hari;
	}

	@Column(name = "start", length = 50, nullable = false)
	public String getJam_mulai() {
		return jam_mulai;
	}

	public void setJam_mulai(String jam_mulai) {
		this.jam_mulai = jam_mulai;
	}

	@Column(name = "finish", length = 50, nullable = false)
	public String getJam_selesai() {
		return jam_selesai;
	}

	public void setJam_selesai(String jam_selesai) {
		this.jam_selesai = jam_selesai;
	}

}
