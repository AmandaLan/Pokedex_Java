package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Pokemon;

@Controller
public class AccueilController {
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
}
