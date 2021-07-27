package com.original.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.original.domain.Route;
import com.original.repository.RouteRepository;

@Service
public class RouteService {

	@Autowired
	private RouteRepository routeRepository;

	public Route saveRoute(Route route) {
		boolean alreadyExists = false;
		Iterable<Route> allRoutes = routeRepository.findAll();
		for (Route r : allRoutes) {
			if (r.equals(route)) {
				alreadyExists = true;
			}
		}
		if (!alreadyExists) {
			return routeRepository.save(route);
		}

		return null;
	}
}
