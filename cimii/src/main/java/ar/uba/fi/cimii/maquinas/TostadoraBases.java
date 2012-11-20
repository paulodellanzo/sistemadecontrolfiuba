package ar.uba.fi.cimii.maquinas;

import ar.uba.fi.cimii.control.ControlProceso;

public class TostadoraBases {
	
	private static TostadoraBases INSTANCE = null;
	
	private int cantPanes;
	
	private boolean enEspera;
	
	private int temperatura;
	
	private boolean tapaCerrada;
	
	private TostadoraBases() {
		cantPanes = 0;
		enEspera = true;
	}
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new TostadoraBases();
        }
    }
	
	public static TostadoraBases getInstance() {
        createInstance();
        return INSTANCE;
    }
	
	public int getCantPanes() {
		return cantPanes;
	}
	
	public void agregarPan() {
		if (cantPanes<6 && enEspera) {
			cantPanes++;
			ControlProceso.getInstance().comenzarProceso();
		}
	}
	
	public boolean isEnEspera() {
		return enEspera;
	}

	public void setEnEspera(boolean enEspera) {
		this.enEspera = enEspera;
	}
	
	public int getTemperatura() {
		return temperatura;
	}
	
	public void vaciarPanes() {
		cantPanes = 0;
	}
	
	public void aumentarTemp() {
		temperatura+=5+((Math.random()-0.5)*4);
		System.out.println("Tostadora bases: " + temperatura);
	}
	
	public void resetTemp() {
		temperatura = 0;
	}
	
	public boolean isTapaCerrada() {
		return tapaCerrada;
	}

	public void setTapaCerrada(boolean tapaCerrada) {
		this.tapaCerrada = tapaCerrada;
	}
}
