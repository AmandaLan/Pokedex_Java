package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the pokemon_est_de_type database table.
 * 
 */
@Entity
@Table(name="pokemon_est_de_type", uniqueConstraints= @UniqueConstraint(columnNames={"pokemon_id", "type_id"}))
@NamedQuery(name="PokemonEstDeType.findAll", query="SELECT p FROM PokemonEstDeType p")
public class PokemonEstDeType implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private PokemonEstDeTypePK id;

	//bi-directional many-to-one association to Pokemon
	@JsonIgnore
	@MapsId("pokemonId")
    @JoinColumn(name = "pokemon_id")
	@ManyToOne(optional = false, targetEntity = Pokemon.class, fetch = FetchType.EAGER)
	private Pokemon pokemon;

	//bi-directional many-to-one association to TypePokemon
	@JsonIgnore
	@MapsId("typeId")
    @JoinColumn(name = "type_id")
	@ManyToOne(optional = false, targetEntity = TypePokemon.class, fetch = FetchType.EAGER)
	private TypePokemon typePokemon;

	public PokemonEstDeType() {
	}

	public PokemonEstDeTypePK getId() {
		return this.id;
	}

	public void setId(PokemonEstDeTypePK id) {
		this.id = id;
	}
	
	public Pokemon getPokemon() {
		return this.pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public TypePokemon getTypePokemon() {
		return this.typePokemon;
	}

	public void setTypePokemon(TypePokemon typePokemon) {
		this.typePokemon = typePokemon;
	}

}