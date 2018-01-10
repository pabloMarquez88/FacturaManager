package com.facturamanager.model;

public class Puntuacion {

	private Persona personaVotante;
	private Persona personaElegida;
	private Evento evento;

	public Persona getPersonaVotante() {
		return personaVotante;
	}

	public void setPersonaVotante(Persona personaVotante) {
		this.personaVotante = personaVotante;
	}

	public Persona getPersonaElegida() {
		return personaElegida;
	}

	public void setPersonaElegida(Persona personaElegida) {
		this.personaElegida = personaElegida;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
