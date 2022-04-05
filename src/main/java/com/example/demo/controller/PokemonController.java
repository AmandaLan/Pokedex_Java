package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pokemon;
import com.example.demo.repository.PokemonRepository;
import com.example.demo.service.PokemonService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PokemonController {
	@Autowired
	private PokemonService pokemonService;
	
	@Autowired
	private PokemonRepository pokemonRepository;

	@GetMapping("/pokemons")
	public Iterable<Pokemon> getPokemons(){
		return pokemonService.getPokemons();
	}
	
	@GetMapping("/addpokemonpage")
	public String showPokemonForm(Pokemon pokemon) {
		return "addPokemon";
	}
	
    @PostMapping("/addpokemon")
    public String addPokemon(@Valid Pokemon pokemon, BindingResult result, Model model) {        
        pokemonRepository.save(pokemon);
        return "redirect:/accueil";
    }	
}
