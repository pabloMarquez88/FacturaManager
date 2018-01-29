package com.facturamanager.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facturamanager.dao.FacturaDao;
import com.facturamanager.model.BusinessFacturaException;
import com.facturamanager.model.Evento;
import com.facturamanager.model.Persona;
import com.facturamanager.model.Puntuacion;
import com.facturamanager.service.FacturaService;

@Service
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	private FacturaDao facturaDao;

	@Override
	@Transactional
	public Persona altaUsuario(Persona p) throws BusinessFacturaException {
		if (p.getNombre().isEmpty()) {
			/**
			 * ERROR, SE DEBE COMPLETAR EL NOMBRE
			 */
		}
		if (p.getClave().isEmpty()) {
			/**
			 * ERROR, SE DEBE COMPLETAR LA CLAVE
			 */
		}
		if (p.getCorreo().isEmpty()) {
			/**
			 * ERROR, SE DEBE COMPLETAR EL CORREO
			 */
		}
		Persona salida = facturaDao.altaUsuario(p);
		return salida;
	}

	@Override
	public Evento crearEvento(Evento e) throws BusinessFacturaException {
		// TODO Auto-generated method stub
		facturaDao.crearEvento(e);
		return e;
	}

	@Override
	public Boolean asignarPersonaEvento(Persona p, Evento e, String posicion) throws BusinessFacturaException {
		if (p.getId().equals(e.getPersona1().getId())) {
			/**
			 * ERROR, LA PERSONA YA ESTA ASIGNADA AL EVENTO
			 */
			throw new BusinessFacturaException("La persona ya esta asignada al evento");
		}
		if (p.getId().equals(e.getPersona2().getId())) {
			/**
			 * ERROR, LA PERSONA YA ESTA ASIGNADA AL EVENTO
			 */
			throw new BusinessFacturaException("La persona ta esta asignada al evento");
		}
		facturaDao.asignarPersonaEvento(p, e, posicion);
		return true;
	}

	@Override
	@Transactional
	public Boolean puntuar(Evento e, Persona personaElegida, Persona personaVotante) throws BusinessFacturaException {
		if (personaElegida.getId().equals(personaVotante.getId())) {
			/**
			 * ERRROR, LA PERSONA VOTANTE ES LA MISMA QUE LA ELEGIDA
			 */
			throw new BusinessFacturaException("No se puede votar a uno mismo");
		}
		/**
		 * COMPROBAR SI EL DIA ES EL MISMO, SINO INDICAR QUE LA VOTACION CADUCO
		 */
		Calendar c1 = Calendar.getInstance();
		c1.setTime(e.getFechaEvento());
		Calendar c2 = Calendar.getInstance();

		boolean votacionHabilitada = false;

		if (c1.get(Calendar.DAY_OF_MONTH) - c2.get(Calendar.DAY_OF_MONTH) == 0) {
			if (c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH) == 0) {
				if (c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR) == 0) {
					votacionHabilitada = true;
				}
			}
		}
		if (votacionHabilitada) {
			Puntuacion actual = facturaDao.getPuntuacion(e, personaVotante);
			if (actual == null) {
				facturaDao.puntuar(e, personaElegida, personaVotante);
			} else {
				throw new BusinessFacturaException("Ya votaste");
			}
		} else {
			/**
			 * LA VOTACION NO ESTA HABILITADA POR QUE YA CADUCO
			 */
			throw new BusinessFacturaException("La votacion caduco");
		}
		return null;
	}

	@Override
	public List<Evento> getListadoEventos() throws BusinessFacturaException {
		List<Evento> salida = this.facturaDao.getListadoEventos();
		System.out.println(salida.get(0).getPuntuaciones());
		return salida;
	}

	@Override
	public Evento getEventoSemana() throws BusinessFacturaException {
		return this.facturaDao.getEventoSemana();
	}

}
