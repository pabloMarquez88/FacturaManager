package com.facturamanager.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.facturamanager.dao.FacturaDao;
import com.facturamanager.model.BusinessFacturaException;
import com.facturamanager.model.Evento;
import com.facturamanager.model.Persona;
import com.facturamanager.model.Puntuacion;

@Component
public class FacturaDaoImpl implements FacturaDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Persona altaUsuario(Persona p) throws BusinessFacturaException {
		Persona pp = (Persona) entityManager.createQuery("from Persona where correo = :email").setParameter("email", p.getCorreo()).getSingleResult();
		if (pp != null) {
			/**
			 * ERROR EL OBJETO YA EXISTE
			 */
			throw new BusinessFacturaException("El correo electronico ya esta registrado");
		}
		entityManager.persist(p);
		return p;
	}

	@Override
	public Evento crearEvento(Evento e) throws BusinessFacturaException {
		Evento ee = (Evento) entityManager.createQuery("from Evento where fechaEvento = :fecha").setParameter("fecha", e.getFechaEvento(), TemporalType.DATE).getSingleResult();
		if (ee != null) {
			/**
			 * ERROR EL OBJETO YA EXISTE
			 */
			throw new BusinessFacturaException("El evento ya esta creado");
		}
		entityManager.persist(e);
		return e;
	}

	@Override
	public Evento asignarPersonaEvento(Persona p, Evento e, String posicion) {
		Evento eventoExistente = entityManager.find(Evento.class, e.getId());
		if (eventoExistente != null) {
			e = eventoExistente;
		}
		if (posicion.equals("1")) {
			e.setPersona1(p);
		} else {
			e.setPersona2(p);
		}
		entityManager.merge(e);
		return e;
	}

	@Override
	public Boolean puntuar(Evento e, Persona personaElegida, Persona personaVotante) {
		Puntuacion pun = new Puntuacion();
		pun.setEvento(e);
		pun.setPersonaElegida(personaElegida);
		pun.setPersonaVotante(personaVotante);
		entityManager.persist(pun);
		return true;
	}
	
	@Override
	public Puntuacion getPuntuacion (Evento e, Persona pv){
		List salida = entityManager.createQuery("from Puntuacion pp WHERE pp.personaVotante.id = ? AND pp.evento.id = ?").setParameter(1, pv.getId()).setParameter(2, e.getId()).getResultList();
		if (salida != null){
			return (Puntuacion) salida.get(0);
		}
		return null;
		
	}

	@Override
	public List<Evento> getListadoEventos() {
		List<Evento> salida = entityManager.createQuery("from Evento").getResultList();
		return salida;
	}

	@Override
	public Evento getEventoSemana() {
		List<Evento> salida = entityManager.createQuery("from Evento e ORDER BY e.fechaEvento DESC").getResultList();
		if (salida != null && salida.size() > 0) {
			return salida.get(0);
		} else {
			return null;
		}
	}

}
