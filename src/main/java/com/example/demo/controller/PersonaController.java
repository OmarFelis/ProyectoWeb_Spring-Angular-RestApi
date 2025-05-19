package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.service.IPersonaService;

@RestController
public class PersonaController {

	@Autowired
	private IPersonaService service;
	
	@GetMapping
	public List<Persona> listar(){
		return service.listar();
	}
}
