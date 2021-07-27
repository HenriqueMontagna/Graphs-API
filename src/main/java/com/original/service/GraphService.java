package com.original.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.original.domain.Graph;
import com.original.domain.Route;
import com.original.repository.GraphRepository;

@Service
public class GraphService {

	@Autowired
	private GraphRepository graphRepository;

	@Autowired
	private RouteService routeService;

	public Graph saveGraph(Graph graph) {
		Graph createdGraph = graphRepository.save(graph);
		List<Route> listOfRoutes = graph.getData();
		listOfRoutes.forEach(route -> {
			route.setGraph(createdGraph);
			routeService.saveRoute(route);
		});
		return createdGraph;
	}
	
	public Graph getGraph(Long id) {
		Graph foundGraph;
		try {
			foundGraph = graphRepository.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		} 		
		
		return foundGraph;
	}

}
