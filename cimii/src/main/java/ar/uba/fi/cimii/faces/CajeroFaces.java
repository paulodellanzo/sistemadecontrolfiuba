package ar.uba.fi.cimii.faces;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ar.uba.fi.cimii.domain.entities.Pedido;

@SessionScoped
@ManagedBean(name = "cajero")
public class CajeroFaces {

	private List<Pedido> pedidoBebidas;
	
	@ManagedProperty(value="#{cocinero}")
	private CocineroFaces cocineroFaces;

	public CajeroFaces() {
		super();
		
		pedidoBebidas = new ArrayList<Pedido>();
		
		pedidoBebidas.add(new Pedido("bebida1", Calendar.getInstance()));
		pedidoBebidas.add(new Pedido("bebida2", Calendar.getInstance()));
	}

	public List<Pedido> getPedidoBebidas() {
		return pedidoBebidas;
	}

	public void setPedidoBebidas(List<Pedido> pedidoBebidas) {
		this.pedidoBebidas = pedidoBebidas;
	}

	public List<Pedido> getPedidoHamburguesas() {
		return cocineroFaces.getPedidoHamburguesas();
	}

	public void setPedidoHamburguesas(List<Pedido> pedidoHamburguesas) {
		cocineroFaces.setPedidoHamburguesas(pedidoHamburguesas);
	}
	
	public CocineroFaces getCocineroFaces() {
		return cocineroFaces;
	}

	public void setCocineroFaces(CocineroFaces cocineroFaces) {
		this.cocineroFaces = cocineroFaces;
	}

	public void pedirCoca() {
		pedidoBebidas.add(new Pedido("Coca-Cola", Calendar.getInstance()));
	}
	
	public void pedirFanta() {
		pedidoBebidas.add(new Pedido("Fanta", Calendar.getInstance()));
	}
	
	public void pedirSevenUp() {
		pedidoBebidas.add(new Pedido("7up", Calendar.getInstance()));
	}
	
	public void pedirHamb() {
		cocineroFaces.getPedidoHamburguesas().add(new Pedido("Hamburguesa simple", Calendar.getInstance()));
	}
}