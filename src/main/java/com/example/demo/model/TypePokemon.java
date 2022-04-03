package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type_pokemon database table.
 * 
 */
@Entity
@Table(name="type_pokemon")
@NamedQuery(name="TypePokemon.findAll", query="SELECT t FROM TypePokemon t")
public class TypePokemon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String label;

	//bi-directional many-to-one association to PokemonEstDeType
	@OneToMany(mappedBy="typePokemon")
	private List<PokemonEstDeType> pokemonEstDeTypes;

	public TypePokemon() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<PokemonEstDeType> getPokemonEstDeTypes() {
		return this.pokemonEstDeTypes;
	}

	public void setPokemonEstDeTypes(List<PokemonEstDeType> pokemonEstDeTypes) {
		this.pokemonEstDeTypes = pokemonEstDeTypes;
	}

	public PokemonEstDeType addPokemonEstDeType(PokemonEstDeType pokemonEstDeType) {
		getPokemonEstDeTypes().add(pokemonEstDeType);
		pokemonEstDeType.setTypePokemon(this);

		return pokemonEstDeType;
	}

	public PokemonEstDeType removePokemonEstDeType(PokemonEstDeType pokemonEstDeType) {
		getPokemonEstDeTypes().remove(pokemonEstDeType);
		pokemonEstDeType.setTypePokemon(null);

		return pokemonEstDeType;
	}

}