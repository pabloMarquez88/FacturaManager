package com.facturamanager.model;

import java.util.Date;
import java.util.List;

public class Evento {
	private Long id;
	private Persona persona1;
	private Persona persona2;
	private Date fechaEvento;
	private List<Puntuacion> puntuaciones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Puntuacion> getPuntuaciones() {
		return puntuaciones;
	}

	public void setPuntuaciones(List<Puntuacion> puntuaciones) {
		this.puntuaciones = puntuaciones;
	}

	public Persona getPersona1() {
		return persona1;
	}

	public void setPersona1(Persona persona1) {
		this.persona1 = persona1;
	}

	public Persona getPersona2() {
		return persona2;
	}

	public void setPersona2(Persona persona2) {
		this.persona2 = persona2;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

}
