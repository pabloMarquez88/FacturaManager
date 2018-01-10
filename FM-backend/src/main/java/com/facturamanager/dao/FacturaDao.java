package com.facturamanager.dao;

import java.util.List;

import com.facturamanager.model.BusinessFacturaException;
import com.facturamanager.model.Evento;
import com.facturamanager.model.Persona;

public interface FacturaDao {
	public Persona altaUsuario(Persona p) throws BusinessFacturaException;
	public Evento crearEvento(Evento e) throws BusinessFacturaException;
	public Evento asignarPersonaEvento(Persona p, Evento e, String posicion) throws BusinessFacturaException;
	public Boolean puntuar(Evento e, Persona personaElegida, Persona personaVotante) throws BusinessFacturaException;
	public List<Evento> getListadoEventos() throws BusinessFacturaException;
	public Evento getEventoSemana() throws BusinessFacturaException;
}
