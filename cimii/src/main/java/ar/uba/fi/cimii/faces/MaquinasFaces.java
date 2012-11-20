package ar.uba.fi.cimii.faces;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Min;

import ar.uba.fi.cimii.maquinas.CintaTransportadora;
import ar.uba.fi.cimii.maquinas.Dispenser;
import ar.uba.fi.cimii.maquinas.Parrilla;
import ar.uba.fi.cimii.maquinas.TostadoraBases;
import ar.uba.fi.cimii.maquinas.TostadoraCorona;

@ApplicationScoped
@ManagedBean(name = "maquinas")
public class MaquinasFaces {
	
	private TostadoraBases tostBase;
	
	private TostadoraCorona tostCorona;
	
	private Parrilla parrilla;
	
	private CintaTransportadora cinta;
	
	private Dispenser dispenser;
	
	public MaquinasFaces() {
		super();
		tostBase = TostadoraBases.getInstance();
		tostCorona = TostadoraCorona.getInstance();
		parrilla = Parrilla.getInstance();
		dispenser = Dispenser.getInstance();
	}

	public TostadoraBases getTostBase() {
		return tostBase;
	}

	public TostadoraCorona getTostCorona() {
		return tostCorona;
	}

	public Parrilla getParrilla() {
		return parrilla;
	}

	public CintaTransportadora getCinta() {
		return cinta;
	}

	public Dispenser getDispenser() {
		return dispenser;
	}
	
}