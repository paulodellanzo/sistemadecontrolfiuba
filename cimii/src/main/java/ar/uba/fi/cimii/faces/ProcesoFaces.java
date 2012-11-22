package ar.uba.fi.cimii.faces;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Min;

import ar.uba.fi.cimii.control.ControlProceso;
import ar.uba.fi.cimii.control.Proceso;
import ar.uba.fi.cimii.maquinas.CintaTransportadora;
import ar.uba.fi.cimii.maquinas.Dispenser;
import ar.uba.fi.cimii.maquinas.Parrilla;
import ar.uba.fi.cimii.maquinas.TostadoraBases;
import ar.uba.fi.cimii.maquinas.TostadoraCorona;

@ApplicationScoped
@ManagedBean(name = "proceso")
public class ProcesoFaces {
	
	private ControlProceso controlProceso;
	
	public ProcesoFaces() {
		super();
		controlProceso = ControlProceso.getInstance();
	}

	public Proceso getProcesoActual() {
		return controlProceso.getProcesoActual();
	}
	
}