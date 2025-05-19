package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.repository.IPersonaRepository;
import com.example.demo.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	IPersonaRepository repo;
	
	@Override
	public List<Persona> listar() {
		
		return repo.findAll();
	}

	@Override
	public Persona registrar(Persona persona) {
		return repo.save(persona);
	}

	@Override
	public Persona actualizar(Persona persona) {
		return repo.save(persona);
	}

	@Override
	public void eliminar(Integer codigo) {
		 repo.deleteById(codigo);
	}

	@Override
	public Persona ListarPorId(Integer codigo) {
		return repo.findById(codigo).orElse(null);
	}

	
}
