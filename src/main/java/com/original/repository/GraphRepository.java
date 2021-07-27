package com.original.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.original.domain.Graph;

@Repository
public interface GraphRepository extends CrudRepository<Graph, Long>{

}
