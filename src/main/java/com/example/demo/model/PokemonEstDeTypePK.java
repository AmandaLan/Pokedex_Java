package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_est_de_type database table.
 * 
 */
@Embeddable
public class PokemonEstDeTypePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokemon_id", insertable=false, updatable=false)
	private Long pokemonId;

	@Column(name="type_id", insertable=false, updatable=false)
	private Long typeId;

	public PokemonEstDeTypePK() {
	}
	public Long getPokemonId() {
		return this.pokemonId;
	}
	public void setPokemonId(Long pokemonId) {
		this.pokemonId = pokemonId;
	}
	public Long getTypeId() {
		return this.typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PokemonEstDeTypePK)) {
			return false;
		}
		PokemonEstDeTypePK castOther = (PokemonEstDeTypePK)other;
		return 
			this.pokemonId.equals(castOther.pokemonId)
			&& this.typeId.equals(castOther.typeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokemonId.hashCode();
		hash = hash * prime + this.typeId.hashCode();
		
		return hash;
	}
}