package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.PokemonEstDeType;
import com.example.demo.model.PokemonTypeCustom;
import com.example.demo.service.PokemonEstDeTypeService;

@Controller
public class AccueilController {
	
	@Autowired
	private PokemonEstDeTypeService pokemonEstDeTypeService;
	
	@RequestMapping("/")
	public String intro()
	{
		return "introAnim";
	}

	@RequestMapping("/accueil")
	public String accueil()
	{
		return "accueil";
	}
	
//	@RequestMapping("/pokedex")
//	public String pokedex()
//	{
//		return "pokedex";
//	}
	@RequestMapping("/pokedex")
	public String getPokemonType(Model model){
		Iterable<PokemonEstDeType> listPokemonType = pokemonEstDeTypeService.getPokemons();
		List<PokemonTypeCustom> pokemo = new ArrayList<PokemonTypeCustom>();
		for(PokemonEstDeType pokemonType: listPokemonType) {
			
			PokemonTypeCustom pokemon = new PokemonTypeCustom(pokemonType.getPokemon().getName(), pokemonType.getPokemon().getNumber(), pokemonType.getPokemon().getHealthPoints(), pokemonType.getTypePokemon().getLabel());
			
			pokemo.add(pokemon);
		}
		model.addAttribute("pokemo", pokemo);
		return "pokedex";
	}
}
