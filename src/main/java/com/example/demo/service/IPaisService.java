package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Pais;

public interface IPaisService {

	List<Pais> listar();
	Pais registrar(Pais pais);
	Pais actualizar(Pais pais);
	void eliminar(Integer codigo);
	Pais ListarPorId(Integer codigo);
}
