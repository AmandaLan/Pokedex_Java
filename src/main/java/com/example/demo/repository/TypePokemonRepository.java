package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TypePokemon;

@Repository
public interface TypePokemonRepository extends CrudRepository<TypePokemon, Long> {

}
