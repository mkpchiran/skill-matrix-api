package com.wiley.internal.apps.web.rest;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/health")
public class HealthController {

	@GetMapping
	public ResponseEntity<Object> handleSkillGetAll() {
		return new ResponseEntity<>(new Date() + " : Aplication is running" ,HttpStatus.OK );
	}
}
