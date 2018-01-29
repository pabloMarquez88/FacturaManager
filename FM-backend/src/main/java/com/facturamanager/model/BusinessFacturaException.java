package com.facturamanager.model;

public class BusinessFacturaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mensaje;

	public BusinessFacturaException(Exception e, String mensaje) {
		super(mensaje, e);
		this.mensaje = mensaje;
	}

	public BusinessFacturaException(String mensaje) {
		super(mensaje);
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
