package ar.uba.fi.cimii.faces;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ar.uba.fi.cimii.control.Alertas;
import ar.uba.fi.cimii.domain.entities.Pedido;
import ar.uba.fi.cimii.maquinas.Bebidas;

@SessionScoped
@ManagedBean(name = "cajero")
public class CajeroFaces {

	Bebidas bebidas;
	
	@ManagedProperty(value="#{cocinero}")
	private CocineroFaces cocineroFaces;
	
	private List<String> alertas;

	public CajeroFaces() {
		super();
		bebidas = Bebidas.getInstance();
	}

	public List<Pedido> getPedidoBebidas() {
		return bebidas.getPedidoBebidas();
	}

	public void setPedidoBebidas(List<Pedido> pedidoBebidas) {
		bebidas.setPedidoBebidas(pedidoBebidas);
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
		bebidas.getPedidoBebidas().add(new Pedido("Coca-Cola", Calendar.getInstance()));
	}
	
	public void pedirFanta() {
		bebidas.getPedidoBebidas().add(new Pedido("Fanta", Calendar.getInstance()));
	}
	
	public void pedirSevenUp() {
		bebidas.getPedidoBebidas().add(new Pedido("7up", Calendar.getInstance()));
	}
	
	public void pedirHamb() {
		cocineroFaces.getPedidoHamburguesas().add(new Pedido("Hamburguesa simple", Calendar.getInstance()));
	}

	public Bebidas getBebidas() {
		return bebidas;
	}
	
	public void updateAlertas() {
		alertas = Alertas.getInstance().getAlertasCajero();
	}
	
	public void clearAlertas() {
		Alertas.getInstance().getAlertasCajero().clear();
	}

	public List<String> getAlertas() {
		return alertas;
	}

	public void setAlertas(List<String> alertas) {
		this.alertas = alertas;
	}
	
}