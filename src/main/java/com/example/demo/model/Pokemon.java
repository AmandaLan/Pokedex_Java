package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the pokemon database table.
 * 
 */
@Entity
@NamedQuery(name="Pokemon.findAll", query="SELECT p FROM Pokemon p")
public class Pokemon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="health_points")
	private Integer healthPoints;

	@Column(name="name_")
	private String name;

	@Column(name="number_")
	private Integer number;

	//bi-directional many-to-one association to Pokemon
	@ManyToOne
	@JoinColumn(name="evolution")
	private Pokemon pokemon;

	//bi-directional many-to-one association to Pokemon
	@Nullable
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="pokemon", orphanRemoval = true)
	private List<Pokemon> pokemons;

	//bi-directional many-to-one association to PokemonDresse
	@Nullable
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="pokemon", orphanRemoval = true)
	private List<PokemonDresse> pokemonDresses;

	//bi-directional many-to-one association to PokemonEstDeType
	@Nullable
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="pokemon", orphanRemoval = true)
	private List<PokemonEstDeType> pokemonEstDeTypes;

	public Pokemon() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getHealthPoints() {
		return this.healthPoints;
	}

	public void setHealthPoints(Integer healthPoints) {
		this.healthPoints = healthPoints;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Pokemon getPokemon() {
		return this.pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public List<Pokemon> getPokemons() {
		return this.pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public Pokemon addPokemon(Pokemon pokemon) {
		getPokemons().add(pokemon);
		pokemon.setPokemon(this);

		return pokemon;
	}

	public Pokemon removePokemon(Pokemon pokemon) {
		getPokemons().remove(pokemon);
		pokemon.setPokemon(null);

		return pokemon;
	}

	public List<PokemonDresse> getPokemonDresses() {
		return this.pokemonDresses;
	}

	public void setPokemonDresses(List<PokemonDresse> pokemonDresses) {
		this.pokemonDresses = pokemonDresses;
	}

	public PokemonDresse addPokemonDress(PokemonDresse pokemonDress) {
		getPokemonDresses().add(pokemonDress);
		pokemonDress.setPokemon(this);

		return pokemonDress;
	}

	public PokemonDresse removePokemonDress(PokemonDresse pokemonDress) {
		getPokemonDresses().remove(pokemonDress);
		pokemonDress.setPokemon(null);

		return pokemonDress;
	}

	public List<PokemonEstDeType> getPokemonEstDeTypes() {
		return this.pokemonEstDeTypes;
	}

	public void setPokemonEstDeTypes(List<PokemonEstDeType> pokemonEstDeTypes) {
		this.pokemonEstDeTypes = pokemonEstDeTypes;
	}

	public PokemonEstDeType addPokemonEstDeType(PokemonEstDeType pokemonEstDeType) {
		getPokemonEstDeTypes().add(pokemonEstDeType);
		pokemonEstDeType.setPokemon(this);

		return pokemonEstDeType;
	}

	public PokemonEstDeType removePokemonEstDeType(PokemonEstDeType pokemonEstDeType) {
		getPokemonEstDeTypes().remove(pokemonEstDeType);
		pokemonEstDeType.setPokemon(null);

		return pokemonEstDeType;
	}

}