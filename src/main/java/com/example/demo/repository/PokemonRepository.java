package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Pokemon;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
	 @Query(value = "SELECT * FROM  pokemon WHERE pokemon.name_ = :pokemonName", nativeQuery = true)
 Optional<Pokemon> findByName(String pokemonName) ;
	

	
	

	
	}

	

