package com.example.rimpyassignment10.web;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.rimpyassignment10.config.SpoonacularConfiguration;
import com.example.rimpyassignment10.dto.DayResponse;
import com.example.rimpyassignment10.dto.WeekResponse;

@RestController
public class SpoonacularController {

	@Autowired
	private SpoonacularConfiguration config;

	/*
	 * @GetMapping("/mealplanner/week") public ResponseEntity<WeekResponse>
	 * getWeekMeals(String numCalories, String diet, String exclusions) { return
	 * getSpoonacularAPIWeekResponse(numCalories, diet, exclusions); }
	 * 
	 * @GetMapping("/mealplanner/day") public ResponseEntity<DayResponse>
	 * getDayMeals(String numCalories, String diet, String exclusions) { return
	 * getSpoonacularAPIDayResponse(numCalories, diet, exclusions); }
	 */

	@GetMapping("/mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals() {
		return getSpoonacularAPIWeekResponse();
	}

	@GetMapping("/mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals() {
		return getSpoonacularAPIDayResponse();
	}

	public ResponseEntity<WeekResponse> getSpoonacularAPIWeekResponse() {
		URI uri = UriComponentsBuilder.fromHttpUrl(config.getMealPlanUrl())
				                      .queryParam("timeFrame", "week")
				                      .queryParam("apiKey", "7a50a47ed75a4f5e9606e610628eb64f")
				                      .build().toUri();
				/*
				 * .queryParam("targetCalories", Integer.parseInt(numCalories))
				 * .queryParam("diet", diet) .queryParam("exclude", exclusions).
				 */
		RestTemplate rt = new RestTemplate();
		ResponseEntity<WeekResponse> weekResponse = rt.getForEntity(uri, WeekResponse.class);

		System.out.println(weekResponse.getBody());
		return weekResponse;

	}

	public ResponseEntity<DayResponse> getSpoonacularAPIDayResponse() {
		URI uri = UriComponentsBuilder.fromHttpUrl(config.getMealPlanUrl())
				                      .queryParam("timeFrame", "day")
				                      .queryParam("apiKey", "7a50a47ed75a4f5e9606e610628eb64f").build().toUri();

		RestTemplate rt1 = new RestTemplate();
		ResponseEntity<DayResponse> dayResponse = rt1.getForEntity(uri, DayResponse.class);

		System.out.println(dayResponse.getBody());
		return dayResponse;

	}

}
