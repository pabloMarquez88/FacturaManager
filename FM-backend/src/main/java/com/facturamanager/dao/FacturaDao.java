package com.facturamanager.dao;

import java.util.List;

import com.facturamanager.model.BusinessFacturaException;
import com.facturamanager.model.Evento;
import com.facturamanager.model.Persona;
import com.facturamanager.model.Puntuacion;

public interface FacturaDao {
	public Persona altaUsuario(Persona p) throws BusinessFacturaException;
	public Evento crearEvento(Evento e) throws BusinessFacturaException;
	public Evento asignarPersonaEvento(Persona p, Evento e, String posicion) throws BusinessFacturaException;
	public Boolean puntuar(Evento e, Persona personaElegida, Persona personaVotante) throws BusinessFacturaException;
	public List<Evento> getListadoEventos() throws BusinessFacturaException;
	public Evento getEventoSemana() throws BusinessFacturaException;
	
	public Puntuacion getPuntuacion (Evento e, Persona pv);
	public Persona getPersonaByNombre(String nombre);
}
