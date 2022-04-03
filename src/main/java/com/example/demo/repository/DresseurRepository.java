package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Dresseur;

@Repository
public interface DresseurRepository extends CrudRepository<Dresseur, Long> {
	
}