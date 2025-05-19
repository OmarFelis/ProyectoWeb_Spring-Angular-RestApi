package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Persona;

public interface IPersonaService {

	List<Persona> listar();
	Persona registrar(Persona persona);
	Persona actualizar(Persona persona);
	void eliminar(Integer codigo);
	Persona ListarPorId(Integer codigo);
	
}
