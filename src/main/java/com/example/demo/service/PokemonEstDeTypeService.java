package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PokemonEstDeType;
import com.example.demo.repository.PokemonEstDeTypeRepository;

import lombok.Data;

@Data
@Service
public class PokemonEstDeTypeService {
	@Autowired 
	private PokemonEstDeTypeRepository pokemonEstDeTypeRepository;
	
	public Iterable<PokemonEstDeType> getPokemons(){
		return pokemonEstDeTypeRepository.findAll();
	}
}
