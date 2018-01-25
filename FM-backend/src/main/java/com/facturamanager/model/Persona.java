package com.facturamanager.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Persona")

public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String correo;
	private String clave;

	@OneToMany(mappedBy = "persona1")
	@JsonBackReference
	private List<Evento> eventosCandidato1;

	@OneToMany(mappedBy = "persona2")
	@JsonBackReference
	private List<Evento> eventosCandidato2;

	@OneToMany(mappedBy = "personaVotante")
	@JsonBackReference
	private List<Puntuacion> votos;

	@OneToMany(mappedBy = "personaElegida")
	@JsonBackReference
	private List<Puntuacion> votosRecibidos;

	public List<Puntuacion> getVotos() {
		return votos;
	}

	public void setVotos(List<Puntuacion> votos) {
		this.votos = votos;
	}

	public List<Puntuacion> getVotosRecibidos() {
		return votosRecibidos;
	}

	public void setVotosRecibidos(List<Puntuacion> votosRecibidos) {
		this.votosRecibidos = votosRecibidos;
	}

	public List<Evento> getEventosCandidato1() {
		return eventosCandidato1;
	}

	public void setEventosCandidato1(List<Evento> eventosCandidato1) {
		this.eventosCandidato1 = eventosCandidato1;
	}

	public List<Evento> getEventosCandidato2() {
		return eventosCandidato2;
	}

	public void setEventosCandidato2(List<Evento> eventosCandidato2) {
		this.eventosCandidato2 = eventosCandidato2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
