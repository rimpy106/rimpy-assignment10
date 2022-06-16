package com.example.rimpyassignment10.web;

import java.net.URI;
import java.util.Optional;

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
	
	@GetMapping("/mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(Optional<Integer> targetCalories, Optional<String> diet,
			Optional<String> exclude) {
		
		RestTemplate rt = new RestTemplate();
		
		URI uri = UriComponentsBuilder.fromHttpUrl(config.getMealPlanUrl())
				.queryParam("timeFrame", "week")
				.queryParam("apiKey", "7a50a47ed75a4f5e9606e610628eb64f")
				.queryParamIfPresent("targetCalories", targetCalories) 
				.queryParamIfPresent("diet", diet)
				.queryParamIfPresent("exclude", exclude).build().toUri();

		
		ResponseEntity<WeekResponse> weekResponse = rt.getForEntity(uri, WeekResponse.class);

		System.out.println(weekResponse.getBody());
		return weekResponse;	
	}

	@GetMapping("/mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(Optional<Integer> targetCalories, Optional<String> diet,
			Optional<String> exclude) {
		
		RestTemplate rt1 = new RestTemplate();
		
		URI uri = UriComponentsBuilder.fromHttpUrl(config.getMealPlanUrl())
				                      .queryParam("timeFrame", "day")
				                      .queryParam("apiKey", "7a50a47ed75a4f5e9606e610628eb64f")
				                  	  .queryParamIfPresent("targetCalories", targetCalories) 
				    				  .queryParamIfPresent("diet", diet)
				    				  .queryParamIfPresent("exclude", exclude).build().toUri();

		
		ResponseEntity<DayResponse> dayResponse = rt1.getForEntity(uri, DayResponse.class);

		System.out.println(dayResponse.getBody());
		return dayResponse;
	}



}
