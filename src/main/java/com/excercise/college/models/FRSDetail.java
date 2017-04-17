package com.excercise.college.models;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FRSDetails")
public class FRSDetail {
	private Integer id;
	private Subject mk;
	private FRS frs;
	private Integer sks;
	
	public FRSDetail() {
		
	}

	public FRSDetail(Integer id, FRS frs, Subject mk,Integer sks) {
		this.id=id;
		this.mk = mk;
		this.frs = frs;
		this.sks=sks;
	}
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "subjectId", nullable = false, //
			foreignKey = @ForeignKey(name = "FRSDetail_ibfk_1"))
	public Subject getMk() {
		return mk;
	}

	public void setMk(Subject mk) {
		this.mk = mk;
	}

	 @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
	 @JoinColumn(name = "frsId", nullable = false, //
	   	foreignKey = @ForeignKey(name = "FRSDetail_ibfk_2") )
	public FRS getFrs() {
		return frs;
	}

	public void setFrs(FRS frs) {
		this.frs = frs;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="sks", nullable=false)
	public Integer getSks() {
		return sks;
	}

	public void setSks(Integer sks) {
		this.sks = sks;
	}
	
	
	
	
	
}
