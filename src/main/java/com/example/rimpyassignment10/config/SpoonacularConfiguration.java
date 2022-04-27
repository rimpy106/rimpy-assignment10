package com.example.rimpyassignment10.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpoonacularConfiguration {

	@Value("${spoonacular.urls.base}")
	private String base;

	@Value("${spoonacular.urls.mealplan}")
	private String mealPlan;

	private String mealPlanUrl;

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getMealPlan() {
		return mealPlan;
	}

	public void setMealPlan(String mealPlan) {
		this.mealPlan = mealPlan;
	}

	@Bean
	public String getMealPlanUrl() {
		mealPlanUrl = base + mealPlan;
		return mealPlanUrl;
	}

	public void setMealPlanUrl(String mealPlanUrl) {
		this.mealPlanUrl = mealPlanUrl;
	}

}
