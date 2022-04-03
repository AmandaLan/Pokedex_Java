package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pokemon;
import com.example.demo.service.PokemonService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PokemonController {
	@Autowired
	private PokemonService pokemonService;

	@GetMapping("/pokemons")
	public Iterable<Pokemon> getPokemons(){
		return pokemonService.getPokemons();
	}
}
