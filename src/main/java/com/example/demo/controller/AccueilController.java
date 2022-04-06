package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Pokemon;
import com.example.demo.model.TypePokemon;
import com.example.demo.repository.PokemonRepository;
import com.example.demo.repository.TypePokemonRepository;
import com.example.demo.model.PokemonEstDeType;
import com.example.demo.model.PokemonTypeCustom;
import com.example.demo.service.PokemonEstDeTypeService;

@Controller
public class AccueilController {
	
	@Autowired
	private PokemonRepository pokemonRepository;

	private PokemonEstDeTypeService pokemonEstDeTypeService;

	private TypePokemonRepository typePokemonRepository;
	
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
	
//	Ajout Pokemon
	
	@GetMapping("/addpokemonpage")
	public String showPokemonForm(Model model) {
		Pokemon pokemon = new Pokemon();
		model.addAttribute("pokemon",pokemon);
        Iterable<TypePokemon> allTypes = typePokemonRepository.findAll();
        model.addAttribute("types", allTypes);
		return "addPokemon";
	}
	
//	Ajout Pokemon dans la BDD + auto-incrémentation n° pokemon
	
    @PostMapping("/addpokemonpage")
    public String addPokemon(@Valid Pokemon pokemon, BindingResult result, Model model) { 
    	
        Iterable<Pokemon> allPokemons = pokemonRepository.findAll();
        pokemon.setNumber(((Collection<?>) allPokemons).size()+1);
        
        pokemonRepository.save(pokemon);
        return "redirect:/accueil";
    }	
    
//	Affichage différents types pour création Pokemon
    
   
//	@RequestMapping("/pokedex")
//	public String pokedex()
//	{
//		return "pokedex";
//	}
	@RequestMapping("/pokedex")
	public String getPokemonType(Model model){
		Iterable<PokemonEstDeType> listPokemonType = pokemonEstDeTypeService.getPokemons();
		List<PokemonTypeCustom> pokemouille = new ArrayList<PokemonTypeCustom>();
		for(PokemonEstDeType pokemonType: listPokemonType) {
			
			PokemonTypeCustom pokemon = new PokemonTypeCustom(pokemonType.getPokemon().getName(), pokemonType.getTypePokemon().getLabel());
			
			pokemouille.add(pokemon);
		}
		model.addAttribute("pokemouille", pokemouille);
		return "pokedex";
	}
}
