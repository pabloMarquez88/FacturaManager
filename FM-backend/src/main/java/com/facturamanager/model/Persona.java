package com.facturamanager.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String correo;
	private String clave;
//	private List<Evento> eventosVotados;
//	private List<Evento> eventosCandidato;

//	public List<Evento> getEventosVotados() {
//		return eventosVotados;
//	}
//
//	public void setEventosVotados(List<Evento> eventosVotados) {
//		this.eventosVotados = eventosVotados;
//	}
//
//	public List<Evento> getEventosCandidato() {
//		return eventosCandidato;
//	}
//
//	public void setEventosCandidato(List<Evento> eventosCandidato) {
//		this.eventosCandidato = eventosCandidato;
//	}

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
