package com.facturamanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.facturamanager.model.BusinessFacturaException;
import com.facturamanager.model.Evento;
import com.facturamanager.model.Persona;
import com.facturamanager.service.FacturaService;

@Controller
public class FacturaManagerController {

	@Autowired
	private FacturaService facturaService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Evento>> getEventos() {
		System.out.println("=================================================asdas");
		List<Evento> listaEventos = null;
		try {
			listaEventos = facturaService.getListadoEventos();
		} catch (BusinessFacturaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<List<Evento>>(listaEventos, HttpStatus.OK);
	}

	@RequestMapping(value = "/altaUsuario", method = RequestMethod.POST)
	public ResponseEntity<Persona> altaUsuario(@RequestBody Persona p) {
		System.out.println("=================================================asdas");
		try {
			p = facturaService.altaUsuario(p);
		} catch (BusinessFacturaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Persona>(p, HttpStatus.OK);
	}

	@RequestMapping(value = "/altaUsuario2", method = RequestMethod.GET)
	public ResponseEntity<Persona> altaUsuario2() {
		System.out.println("=================================================asdas");
		Persona p = new Persona();
		p.setClave("UNA CLAVE");
		p.setCorreo("ASKDJASD@LASJALSD.COM");
		p.setNombre("ñasdas");
		p.setId(12323L);
		return new ResponseEntity<Persona>(p, HttpStatus.OK);
	}

}
