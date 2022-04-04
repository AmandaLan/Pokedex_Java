package com.example.demo.model;

import java.io.Serializable;

public class PokemonTypeCustom implements Serializable  {
	private String pokemon;
	private String type;
	
	public PokemonTypeCustom(String pokemon, String type) {
		super();
		this.pokemon = pokemon;
		this.type = type;
	}
	public String getPokemon() {
		return pokemon;
	}
	public void setPokemon(String pokemon) {
		this.pokemon = pokemon;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
