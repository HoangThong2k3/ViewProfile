package com.se4f7.prj301.entities;

import java.sql.Date;

public class ToDoEntity extends BaseEntity {

	private String name;
	private String description;
	private Date planStart;
	private Date planEnd;
	private int status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.length() < 6 || name.length() > 255) {
			throw new IllegalArgumentException("Name is required and must have a length from 6 to 255 characters.");
		}
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description != null && description.length() > 1500) {
			throw new IllegalArgumentException("Description must have a length up to 1500 characters.");
		}
		this.description = description;
	}

	public Date getPlanStart() {
		return planStart;
	}

	public void setPlanStart(Date planStart) {
		if (planStart == null) {
			throw new IllegalArgumentException("Plan start date is required.");
		}
		Date currentDate = new Date(System.currentTimeMillis());
		if (planStart.compareTo(currentDate) <= 0) {
			throw new IllegalArgumentException("Plan start date must be later than today.");
		}
		if (planEnd != null && planStart.compareTo(planEnd) >= 0) {
			throw new IllegalArgumentException("Plan start date must be earlier than plan end date.");
		}
		this.planStart = planStart;
	}

	public Date getPlanEnd() {
		return planEnd;
	}

	public void setPlanEnd(Date planEnd) {
		if (planEnd == null) {
			throw new IllegalArgumentException("Plan end date is required.");
		}
		Date currentDate = new Date(System.currentTimeMillis());
		if (planEnd.compareTo(currentDate) <= 0) {
			throw new IllegalArgumentException("Plan end date must be later than today.");
		}
		if (planStart != null && planEnd.compareTo(planStart) <= 0) {
			throw new IllegalArgumentException("Plan end date must be later than plan start date.");
		}
		this.planEnd = planEnd;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		if (status != -1 && status != 0 && status != 1 && status != 2) {
			throw new IllegalArgumentException("Invalid status value. Status must be one of [-1, 0, 1, 2].");
		}
		this.status = status;
	}
}