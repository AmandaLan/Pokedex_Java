package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Dresseur;
import com.example.demo.repository.DresseurRepository;

import lombok.Data;

@Data
@Service
public class DresseurService {
	@Autowired 
	private DresseurRepository dresseurRepository;
	
	public Iterable<Dresseur> getDresseurs(){
		return dresseurRepository.findAll();
	}
}
