package com.original.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.original.domain.Graph;
import com.original.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class GraphRepositoryTests {
	
	@Autowired
	private GraphRepository graphRepository;
	
	@Autowired
	private TestUtils testUtils;
	
	
	@Test
	@Order(1)
	public void shouldSaveAGraph() {
		Graph savedGraph = graphRepository.save(testUtils.generateAPopulatedGraph());
		assertThat(savedGraph.getId() instanceof Long).isEqualTo(true);
	}
	
	@Test
	@Order(2)
	public void shouldGetAGraph() {
		Optional<Graph> recoveredGraph = graphRepository.findById(1L);
		assertThat(recoveredGraph.isPresent()).isEqualTo(true);
	}
	
	@Test
	@Order(3)
	public void shouldGetAllGraphs() {
		graphRepository.save(testUtils.generateAPopulatedGraph());
		Iterable<Graph> allGraphsList = graphRepository.findAll();
		Long size = StreamSupport.stream(allGraphsList.spliterator(), false).count();
		assertThat(size).isEqualTo(2L);
	}


}
