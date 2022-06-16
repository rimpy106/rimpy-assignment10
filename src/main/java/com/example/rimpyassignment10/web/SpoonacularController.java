package com.example.rimpyassignment10.web;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	 * @GetMapping("/mealplanner/week") 
	 * public ResponseEntity<WeekResponse> getWeekMeals(Optional<String> numCalories, Optional<String> diet,
	 * Optional<String> exclusions) { String numCalValue = numCalories.isPresent() ?
	 * numCalories.get() : null; String dietValue = diet.isPresent() ? diet.get() :
	 * null; String exclusionsValue = exclusions.isPresent() ? exclusions.get() :
	 * null; return getSpoonacularAPIWeekResponse(numCalValue, dietValue,
	 * exclusionsValue); }
	 */
	
	@GetMapping("/mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(@RequestParam(required=false) Integer targetCalories, 
			@RequestParam(required=false) String diet,
			@RequestParam(required=false) String exclude) {
		
		return getSpoonacularAPIWeekResponse(targetCalories, diet, exclude);
	}

	@GetMapping("/mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals() {
		return getSpoonacularAPIDayResponse();
	}

	public ResponseEntity<WeekResponse> getSpoonacularAPIWeekResponse(Integer targetCalories, String diet,
			String exclude) {
		System.out.println(targetCalories + "-" + diet + "-" + exclude);
		URI uri = UriComponentsBuilder.fromHttpUrl(config.getMealPlanUrl())
				.queryParam("timeFrame", "week")
				.queryParam("apiKey", "7a50a47ed75a4f5e9606e610628eb64f")
				.queryParam("targetCalories", targetCalories)
				.queryParam("diet", diet)
				.queryParam("exclude", exclude).build().toUri();

		RestTemplate rt = new RestTemplate();
		ResponseEntity<WeekResponse> weekResponse = rt.getForEntity(uri, WeekResponse.class);

		System.out.println(weekResponse.getBody());
		return weekResponse;

	}

	public ResponseEntity<DayResponse> getSpoonacularAPIDayResponse() {
		URI uri = UriComponentsBuilder.fromHttpUrl(config.getMealPlanUrl()).queryParam("timeFrame", "day")
				.queryParam("apiKey", "7a50a47ed75a4f5e9606e610628eb64f").build().toUri();

		RestTemplate rt1 = new RestTemplate();
		ResponseEntity<DayResponse> dayResponse = rt1.getForEntity(uri, DayResponse.class);

		System.out.println(dayResponse.getBody());
		return dayResponse;

	}

}
