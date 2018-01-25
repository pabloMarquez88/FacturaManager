package com.facturamanager.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Puntuacion")
public class Puntuacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_votante_ID")

	private Persona personaVotante;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_elegida_ID")

	private Persona personaElegida;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "evento_ID")
	@JsonBackReference
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
