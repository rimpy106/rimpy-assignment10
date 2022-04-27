package com.example.rimpyassignment10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeekResponse {
	@JsonProperty("week")
	private DaysInWeek week;

	public DaysInWeek getWeek() {
		return week;
	}

	public void setWeek(DaysInWeek week) {
		this.week = week;
	}

	@Override
	public String toString() {
		return "WeekResponse [week=" + week + "]";
	}

}
