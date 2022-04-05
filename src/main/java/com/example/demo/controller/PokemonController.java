package com.example.demo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pokemon;
import com.example.demo.model.PokemonEstDeType;
import com.example.demo.model.PokemonTypeCustom;
import com.example.demo.repository.PokemonRepository;
import com.example.demo.service.PokemonEstDeTypeService;
import com.example.demo.service.PokemonService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PokemonController {
	@Autowired
	private PokemonService pokemonService;
	
	@Autowired
	private PokemonEstDeTypeService pokemonEstDeTypeService;
	
	@Autowired
	private PokemonRepository pokemonRepository;

	@GetMapping("/pokemons")
	public Iterable<Pokemon> getPokemons(){
		return pokemonService.getPokemons();
	}
	
//	@GetMapping("/pokemonbyname")
//	@ResponseBody
//	public Optional<Pokemon> getPokemonByName(@RequestParam("name") String name) 
//			throws Exception{
//				return pokemonRepository.getPokemonByName(name);
//	}
	@GetMapping("/types")
	public Iterable<PokemonTypeCustom> getPokemonType(){
		Iterable<PokemonEstDeType> listPokemonType = pokemonEstDeTypeService.getPokemons();
		List<PokemonTypeCustom> pokemouille = new ArrayList<PokemonTypeCustom>();
		for(PokemonEstDeType pokemonType: listPokemonType) {
			
			PokemonTypeCustom pokemon = new PokemonTypeCustom(pokemonType.getPokemon().getName(), pokemonType.getTypePokemon().getLabel());
			
			pokemouille.add(pokemon);
		}
		return pokemouille;
	}
	}
