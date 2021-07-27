package com.original.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.original.domain.Graph;
import com.original.domain.Route;

@Component
public class TestUtils {
	
	public Graph generateAPopulatedGraph() {
		List<Route> routes = new ArrayList<Route>();
		for (int i = 0; i < 9; i++) {
			Route route = generateARoute();
			if (!routes.contains(route)) {
				routes.add(route);
			}
		}
		return new Graph(null, routes);
	}
	
	public Graph generateAEmptyDefaultGraph() {
		return new Graph(1L, new ArrayList<Route>());
	}
	
	public Route generateARoute() {
		Random random = new Random();
		String source, target;
		do {			
			source = generateACharacter();
			target = generateACharacter();
		} while (source.equals(target));
		int distance = random.nextInt(9) + 1;
		return new Route(null, source, target, distance, new Graph(1L, new ArrayList<Route>()));
	}
	
	public String generateACharacter() {
		Random random = new Random();
		return Character.toString((char) (random.nextInt((90 - 65) + 1) + 65));
	}

}
