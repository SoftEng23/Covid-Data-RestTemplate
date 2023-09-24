package com.mosa.covidEndpoint.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mosa.covidEndpoint.service.CovidService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/covid")
@RequiredArgsConstructor
public class CovidController {
	
	private final CovidService covidService = new CovidService();
	@GetMapping("/get-all-country-covid-data")
	public ResponseEntity<?> callRapidEndpointToGetCovidData(){
	return ResponseEntity.ok(covidService.getAllCountryCovidData());
	}
}
