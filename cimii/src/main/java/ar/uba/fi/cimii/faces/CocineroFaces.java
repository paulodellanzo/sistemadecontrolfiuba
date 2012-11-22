package ar.uba.fi.cimii.faces;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.print.attribute.standard.Severity;

import ar.uba.fi.cimii.control.Alertas;
import ar.uba.fi.cimii.control.ControlProceso;
import ar.uba.fi.cimii.domain.entities.Pedido;
import ar.uba.fi.cimii.maquinas.Parrilla;
import ar.uba.fi.cimii.maquinas.TostadoraBases;
import ar.uba.fi.cimii.maquinas.TostadoraCorona;

@SessionScoped
@ManagedBean(name = "cocinero")
public class CocineroFaces {
	
	private List<Pedido> pedidoHamburguesas;
	private List<String> alertas;

	public CocineroFaces() {
		super();
		
		pedidoHamburguesas = new ArrayList<Pedido>();
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
	
	public void confirmarFinalizacion() {
		ControlProceso.getInstance().finalizarProcesoActual();
	}
	
	public void updateAlertas() {
		alertas = Alertas.getInstance().getAlertasCocinero();
	}
	
	public void clearAlertas() {
		Alertas.getInstance().getAlertasCocinero().clear();
	}

	public List<String> getAlertas() {
		return alertas;
	}

	public void setAlertas(List<String> alertas) {
		this.alertas = alertas;
	}
	
}