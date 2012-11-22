package ar.uba.fi.cimii.control;

import java.util.ArrayList;
import java.util.List;

import ar.uba.fi.cimii.maquinas.CintaTransportadora;
import ar.uba.fi.cimii.maquinas.Dispenser;
import ar.uba.fi.cimii.maquinas.Parrilla;
import ar.uba.fi.cimii.maquinas.TostadoraBases;
import ar.uba.fi.cimii.maquinas.TostadoraCorona;

public class Alertas {
	
	private static Alertas INSTANCE = null;
	
	private List<String> alertasCocinero;
	
	private List<String> alertasCajero;
	
	private List<String> alertasAdmin;
	
	private Alertas() {
		alertasCocinero = new ArrayList<String>();
		alertasCajero = new ArrayList<String>();
		alertasAdmin = new ArrayList<String>();
	}
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new Alertas();
        }
    }
	
	public static Alertas getInstance() {
        createInstance();
        return INSTANCE;
    }

	public List<String> getAlertasCocinero() {
		return alertasCocinero;
	}

	public void setAlertasCocinero(List<String> alertasCocinero) {
		this.alertasCocinero = alertasCocinero;
	}

	public List<String> getAlertasCajero() {
		return alertasCajero;
	}

	public void setAlertasCajero(List<String> alertasCajero) {
		this.alertasCajero = alertasCajero;
	}

	public List<String> getAlertasAdmin() {
		return alertasAdmin;
	}

	public void setAlertasAdmin(List<String> alertasAdmin) {
		this.alertasAdmin = alertasAdmin;
	}
	
}
