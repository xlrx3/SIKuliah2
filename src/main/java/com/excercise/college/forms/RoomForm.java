package com.excercise.college.forms;

public class RoomForm {
	private Integer id;
	private Integer roomCode;
	private Integer floorNum;
	private Integer buildingNum;
	private String name;
	
	public RoomForm() {
		
	}
	
	

	public RoomForm(Integer id, Integer roomCode, Integer floorNum, Integer buildingNum, String name) {
		this.id = id;
		this.roomCode = roomCode;
		this.floorNum = floorNum;
		this.buildingNum = buildingNum;
		this.name = name;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(Integer roomCode) {
		this.roomCode = roomCode;
	}

	public Integer getFloorNum() {
		return floorNum;
	}

	public void setFloorNum(Integer floorNum) {
		this.floorNum = floorNum;
	}

	public Integer getBuildingNum() {
		return buildingNum;
	}

	public void setBuildingNum(Integer buildingNum) {
		this.buildingNum = buildingNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
