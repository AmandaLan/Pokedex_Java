package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_dresse database table.
 * 
 */
@Embeddable
public class PokemonDressePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokemon_id")
	private Long pokemonId;

	@Column(name="dresseur_id")
	private Long dresseurId;

	public PokemonDressePK() {
	}
	public Long getPokemonId() {
		return this.pokemonId;
	}
	public void setPokemonId(Long pokemonId) {
		this.pokemonId = pokemonId;
	}
	public Long getDresseurId() {
		return this.dresseurId;
	}
	public void setDresseurId(Long dresseurId) {
		this.dresseurId = dresseurId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PokemonDressePK)) {
			return false;
		}
		PokemonDressePK castOther = (PokemonDressePK)other;
		return 
			this.pokemonId.equals(castOther.pokemonId)
			&& this.dresseurId.equals(castOther.dresseurId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokemonId.hashCode();
		hash = hash * prime + this.dresseurId.hashCode();
		
		return hash;
	}
}