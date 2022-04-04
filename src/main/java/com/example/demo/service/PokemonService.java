package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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

//	public Optional<Pokemon> getPokemonByName(String name) {
//		// TODO Auto-generated method stub
//		return pokemonRepository.getPokemonByName(name);
//	}
}
