package com.original.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/graph")
public class GraphController {
	

	@PostMapping
	public ResponseEntity saveGraph() {
		
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
