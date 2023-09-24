package com.mosa.covidEndpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
public class CovidService {
	/*@Value("${covid.url}")
	private String someUrl;*/
	

    private static final String url = "insert your url";
    private static final String xRapidApiKey = "insert your key";
    private static final String getxRapidApiHost = "insert your host";

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger log = LogManager.getLogger(CovidService.class); // Create a logger instance

    public Object getAllCountryCovidData() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key", xRapidApiKey);
            headers.set("X-RapidAPI-Host", getxRapidApiHost);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);

            // Log the response body using Log4j
            log.info("Output from RapidAPI: {}", response.getBody());

            return response.getBody();
        } catch (Exception e) {
            // Log the error using Log4j
            log.error("Something went wrong", e);

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling endpoint", e);
        }
    }
}