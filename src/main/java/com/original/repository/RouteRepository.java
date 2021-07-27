package com.original.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.original.domain.Route;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {

}
