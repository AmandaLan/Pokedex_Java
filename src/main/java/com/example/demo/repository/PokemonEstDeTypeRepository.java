package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PokemonEstDeType;

@Repository
public interface PokemonEstDeTypeRepository extends CrudRepository<PokemonEstDeType, Long> {
	
}
