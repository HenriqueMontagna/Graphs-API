package com.original.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.original.domain.Graph;
import com.original.service.GraphService;

@RestController
@RequestMapping("/graph")
public class GraphController {
	
	@Autowired
	private GraphService graphService;
	

	@PostMapping
	public ResponseEntity<Graph> saveGraph(@RequestBody Graph graph) {
		Graph response = graphService.saveGraph(graph);
		
		return new ResponseEntity<Graph>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{graphId}")
	public ResponseEntity<Graph> getGraph(@PathVariable Long graphId){
		Graph response = graphService.getGraph(graphId);
		
		if (response != null) {			
			return new ResponseEntity<Graph>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<Graph>(HttpStatus.NOT_FOUND);
		}
	}

}
