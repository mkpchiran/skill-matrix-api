package com.wiley.internal.apps.web.rest;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthResource {

	@GetMapping("/health")
	public ResponseEntity<String> getHealth() {
		return new ResponseEntity<>(new Date() + " : Health Check is Success : ", HttpStatus.OK);
	}
}
