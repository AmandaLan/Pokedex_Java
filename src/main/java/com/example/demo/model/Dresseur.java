package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dresseur database table.
 * 
 */
@Entity
@NamedQuery(name="Dresseur.findAll", query="SELECT d FROM Dresseur d")
public class Dresseur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;


	@Column(name="name_")
	private String name;

	private String ville;

	//bi-directional many-to-one association to PokemonDresse
	@OneToMany(mappedBy="dresseur")
	private List<PokemonDresse> pokemonDresses;

	public Dresseur() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<PokemonDresse> getPokemonDresses() {
		return this.pokemonDresses;
	}

	public void setPokemonDresses(List<PokemonDresse> pokemonDresses) {
		this.pokemonDresses = pokemonDresses;
	}

	public PokemonDresse addPokemonDress(PokemonDresse pokemonDress) {
		getPokemonDresses().add(pokemonDress);
		pokemonDress.setDresseur(this);

		return pokemonDress;
	}

	public PokemonDresse removePokemonDress(PokemonDresse pokemonDress) {
		getPokemonDresses().remove(pokemonDress);
		pokemonDress.setDresseur(null);

		return pokemonDress;
	}

}