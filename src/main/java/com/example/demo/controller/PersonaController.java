package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Persona;
import com.example.demo.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IPersonaService service;
	
	//Lista
	@GetMapping
	public ResponseEntity<List<Persona>> listar(){
		List<Persona> obj = service.listar();
		return new ResponseEntity<List<Persona>>(obj, HttpStatus.OK);
	}
	
	//Crear
	@PostMapping
	public ResponseEntity<Void> registrar(@RequestBody Persona persona){

			Persona obj = service.registrar(persona);
			//Coge localhost:8080/Persona se usa para manipular los otros paremtros de la foreign key
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPersona()).toUri();
			
		return ResponseEntity.created(uri).build();
	}
	
	//Actualizar
	@PutMapping
	public ResponseEntity<Persona> actualizar(@RequestBody Persona persona){
		Persona obj = service.actualizar(persona);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}
	
	//Borrar
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Persona obj = service.ListarPorId(id);
		if(obj == null) {
			throw new Exception("No se encontró ID");
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	//Buscar
	@GetMapping("/{id}")
	public ResponseEntity<Persona> listarPorId(@PathVariable("id")Integer codigo) throws Exception{
		Persona obj = service.ListarPorId(codigo);
		if(obj == null) {
			throw new Exception("No se encontró ID");
		}
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}
	
}
