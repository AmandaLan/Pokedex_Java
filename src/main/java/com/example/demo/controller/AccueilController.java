package com.example.demo.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Pokemon;
import com.example.demo.repository.PokemonRepository;

@Controller
public class AccueilController {
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
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
	
	@GetMapping("/addpokemonpage")
	public String showPokemonForm(Model model) {
		Pokemon pokemon = new Pokemon();
		model.addAttribute("pokemon",pokemon);
		return "addPokemon";
	}
	
    @PostMapping("/addpokemonpage")
    public String addPokemon(@Valid Pokemon pokemon, BindingResult result, Model model) { 
    	
        Iterable<Pokemon> allPokemons = pokemonRepository.findAll();
        pokemon.setNumber(((Collection<?>) allPokemons).size()+1);
        
        pokemonRepository.save(pokemon);
        return "redirect:/accueil";
    }	
	
}
