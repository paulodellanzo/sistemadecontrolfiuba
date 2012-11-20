package ar.uba.fi.cimii.faces;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ar.uba.fi.cimii.domain.entities.Pedido;
import ar.uba.fi.cimii.maquinas.Parrilla;
import ar.uba.fi.cimii.maquinas.TostadoraBases;
import ar.uba.fi.cimii.maquinas.TostadoraCorona;

@SessionScoped
@ManagedBean(name = "cocinero")
public class CocineroFaces {
	
	private List<Pedido> pedidoHamburguesas;

	public CocineroFaces() {
		super();
		
		pedidoHamburguesas = new ArrayList<Pedido>();
		pedidoHamburguesas.add(new Pedido("hamburguesa1", Calendar.getInstance()));
		pedidoHamburguesas.add(new Pedido("hamburguesa2", Calendar.getInstance()));
	}
	
	public List<Pedido> getPedidoHamburguesas() {
		return pedidoHamburguesas;
	}

	public void setPedidoHamburguesas(List<Pedido> pedidoHamburguesas) {
		this.pedidoHamburguesas = pedidoHamburguesas;
	}
	
	public void agregarBase() {
		TostadoraBases.getInstance().agregarPan();
	}
	
	public void agregarCorona() {
		TostadoraCorona.getInstance().agregarPan();
	}
	
	public void agregarCarne() {
		Parrilla.getInstance().agregarCarne();
	}
	
}