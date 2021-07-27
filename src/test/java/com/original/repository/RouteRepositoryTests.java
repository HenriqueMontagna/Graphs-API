package com.original.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.StreamSupport;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.original.domain.Route;
import com.original.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class RouteRepositoryTests {

	@Autowired
	private RouteRepository routeRepository;

	@Autowired
	private GraphRepository graphRepository;

	@Autowired
	private TestUtils testUtils;

	@Test
	@Order(1)
	public void shouldSaveARoute() {
		graphRepository.save(testUtils.generateAEmptyDefaultGraph());
//		System.out.println(createdGraph);
		Route route = routeRepository.save(testUtils.generateARoute());
//		System.out.println(route);
		assertThat(route.getGraph().getId()).isEqualTo(1L);
		assertThat(route.getGraph().getData().size()).isEqualTo(0);
		assertThat(route.getSource()).isInstanceOf(String.class);
		assertThat(route.getTarget()).isInstanceOf(String.class);
		assertThat(route.getDistance()).isInstanceOf(Integer.class);
	}

	@Test
	@Order(2)
	public void shouldGetARoute() {
		Route route = routeRepository.findById(1L).get();
//		System.out.println(route.getId());
		assertThat(route.getId()).isEqualTo(1L);
	}

	@Test
	@Order(3)
	public void shouldGetAllRoutes() {
		routeRepository.save(testUtils.generateARoute());
		Iterable<Route> allRoutesList = routeRepository.findAll();
		Long size = StreamSupport.stream(allRoutesList.spliterator(), false).count();
		assertThat(size).isEqualTo(2L);
	}

//	@Test
//	@Order(4)
//	public void shouldGetRoutesByAttributes() {
//		Route existingRoute = routeRepository.findById(1L).get();
//		Route foundRoute = routeRepository.findOptionalBySourceAndTargetAndDistance(existingRoute.getSource(), existingRoute.getTarget(),
//				existingRoute.getDistance()).get();
//		System.out.println(foundRoute);
//	}

}
