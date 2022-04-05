package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccueilController {
	@RequestMapping("/")
	public String intro()
	{
		return "introAnim";
	}

	@RequestMapping("/accueil")
	public String accueil()
	{
		return "accueil";
	}
}
