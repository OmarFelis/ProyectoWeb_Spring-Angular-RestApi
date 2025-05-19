package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;

	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	@Column(name = "apellidos", length = 100, nullable = false)
	private String apellidos;

	@Column(name = "edad")
	private Integer edad;

	@Column(name = "dni")
	private String dni;

	@Column(name = "correo")
	private String correo;

	@ManyToOne
	@JoinColumn(name = "idPais")
	private Pais pais;

}
