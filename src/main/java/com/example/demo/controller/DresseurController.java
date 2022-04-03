package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dresseur;
import com.example.demo.service.DresseurService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DresseurController {
	@Autowired
	private DresseurService dresseurService;

	@GetMapping("/dresseurs")
	public Iterable<Dresseur> getDresseurs(){
		return dresseurService.getDresseurs();
	}
}
