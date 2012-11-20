package ar.uba.fi.cimii.domain.entities;

import java.io.Serializable;
import java.util.Calendar;

public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8713964248488085450L;
	
	private String descripcion;
	
	private Calendar fecha;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(String descripcion, Calendar fecha) {
		super();
		this.descripcion = descripcion;
		this.fecha = fecha;
	}



	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

}
