package com.example.rimpyassignment10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nutrients {

	@JsonProperty("calories")
	private float calories;
	
	@JsonProperty("carbohydrates")
	private float carbohydrates;
	
	@JsonProperty("fat")
	private float fat;
	
	@JsonProperty("protein")
	private float protein;

	public float getCalories() {
		return calories;
	}

	public void setCalories(float calories) {
		this.calories = calories;
	}

	public float getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(float carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public float getFat() {
		return fat;
	}

	public void setFat(float fat) {
		this.fat = fat;
	}

	public float getProtein() {
		return protein;
	}

	public void setProtein(float protein) {
		this.protein = protein;
	}

	@Override
	public String toString() {
		return "Nutrients [calories=" + calories + ", carbohydrates=" + carbohydrates + ", fat=" + fat + ", protein="
				+ protein + "]";
	}
		
}
