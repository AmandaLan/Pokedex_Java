package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pokemon;
import com.example.demo.repository.PokemonRepository;

import lombok.Data;

@Data
@Service
public class PokemonService {
	@Autowired 
	private PokemonRepository pokemonRepository;
	
	public Iterable<Pokemon> getPokemons(){
		return pokemonRepository.findAll();
	}
}
