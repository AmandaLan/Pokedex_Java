package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the pokemon_dresse database table.
 * 
 */
@Entity
@Table(name="pokemon_dresse", uniqueConstraints= @UniqueConstraint(columnNames={"pokemon_id", "dresseur_id"}))
@NamedQuery(name="PokemonDresse.findAll", query="SELECT p FROM PokemonDresse p")
public class PokemonDresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private PokemonDressePK id;

	private String nickname;

	//bi-directional many-to-one association to Dresseur
	@JsonIgnore
	@MapsId("dresseurId")
    @JoinColumn(name = "dresseur_id")
	@ManyToOne(optional = false, targetEntity = Dresseur.class, fetch = FetchType.EAGER)
	private Dresseur dresseur;

	//bi-directional many-to-one association to Pokemon
	@JsonIgnore
	@MapsId("pokemonId")
    @JoinColumn(name = "pokemon_id")
	@ManyToOne(optional = false, targetEntity = Pokemon.class, fetch = FetchType.EAGER)
	private Pokemon pokemon;

	public PokemonDresse() {
	}

	public PokemonDressePK getId() {
		return this.id;
	}

	public void setId(PokemonDressePK id) {
		this.id = id;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Dresseur getDresseur() {
		return this.dresseur;
	}

	public void setDresseur(Dresseur dresseur) {
		this.dresseur = dresseur;
	}

	public Pokemon getPokemon() {
		return this.pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

}