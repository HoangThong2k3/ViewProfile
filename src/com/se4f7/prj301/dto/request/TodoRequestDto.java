package com.se4f7.prj301.dto.request;

import java.time.LocalDate;

public class TodoRequestDto {

	private String name;

	private String description;
	
	private LocalDate planStart;
	
	private LocalDate planEnd;
	
	private int status;
	
	public TodoRequestDto() {
		super();
	}

	public TodoRequestDto(String name, String description, LocalDate planStart, LocalDate planEnd, int status) {
		super();
		this.name = name;
		this.description = description;
		this.planStart = planStart;
		this.planEnd = planEnd;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getPlanStart() {
		return planStart;
	}

	public void setPlanStart(LocalDate planStart) {
		this.planStart = planStart;
	}

	public LocalDate getPlanEnd() {
		return planEnd;
	}

	public void setPlanEnd(LocalDate planEnd) {
		this.planEnd = planEnd;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
