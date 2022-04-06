package com.example.demo.model;

import java.io.Serializable;

public class PokemonTypeCustom implements Serializable  {
	private String pokemon;
	private Integer number;
	private Integer health;
	private String type;
	private String secType;
	
	
	public PokemonTypeCustom(String pokemon, Integer number, Integer health, String type) {
		super();
		this.pokemon = pokemon;
		this.number = number;
		this.health = health;
		this.type = type;
	}
	public String getPokemon() {
		return pokemon;
	}
	public void setPokemon(String pokemon) {
		this.pokemon = pokemon;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getHealth() {
		return health;
	}
	public void setHealth(Integer health) {
		this.health = health;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSecType() {
		return secType;
	}
	public void setSecType(String secType) {
		this.type = secType;
	}
}
