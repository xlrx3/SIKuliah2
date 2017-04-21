package com.excercise.college.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Rooms")
public class Room {
	private Integer id;
	private Integer roomCode;
	private Integer floorNum;
	private Integer buildingNum;
	private String name;
	
	public Room() {
		
	}


	public Room(Integer id, Integer roomCode, Integer floorNum, Integer buildingNum, String name) {
		super();
		this.id = id;
		this.roomCode = roomCode;
		this.floorNum = floorNum;
		this.buildingNum = buildingNum;
		this.name = name;
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

	@Column(name = "roomCode", nullable = false)
	public Integer getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(Integer roomCode) {
		this.roomCode = roomCode;
	}

	@Column(name = "floorNum", nullable = false)
	public Integer getFloorNum() {
		return floorNum;
	}

	public void setFloorNum(Integer floorNum) {
		this.floorNum = floorNum;
	}

	@Column(name = "buildNum", nullable = false)
	public Integer getBuildingNum() {
		return buildingNum;
	}

	public void setBuildingNum(Integer buildingNum) {
		this.buildingNum = buildingNum;
	}

	@Column(name = "id", length=100, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
