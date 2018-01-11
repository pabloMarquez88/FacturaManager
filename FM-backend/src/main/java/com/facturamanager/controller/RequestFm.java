package com.facturamanager.controller;

import com.facturamanager.model.Evento;
import com.facturamanager.model.Persona;

public class RequestFm {
	private Evento evento;
	private Persona personaElegida;
	private Persona personaVotante;
	private Persona persona;
	private String posicion;

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Persona getPersonaElegida() {
		return personaElegida;
	}

	public void setPersonaElegida(Persona personaElegida) {
		this.personaElegida = personaElegida;
	}

	public Persona getPersonaVotante() {
		return personaVotante;
	}

	public void setPersonaVotante(Persona personaVotante) {
		this.personaVotante = personaVotante;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

}
