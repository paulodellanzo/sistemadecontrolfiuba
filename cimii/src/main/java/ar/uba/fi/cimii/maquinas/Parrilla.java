package ar.uba.fi.cimii.maquinas;

import ar.uba.fi.cimii.control.ControlProceso;

public class Parrilla {
	
	private static Parrilla INSTANCE = null;
	
	private int cantCarnes;
	
	private boolean enEspera;
	
	private int temperatura;
	
	private boolean tapaCerrada;
	
	private Parrilla() {
		cantCarnes = 0;
		enEspera = true;
		temperatura = 0;
	}
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new Parrilla();
        }
    }
	
	public static Parrilla getInstance() {
        createInstance();
        return INSTANCE;
    }
	
	public int getCantCarnes() {
		return cantCarnes;
	}
	
	public void agregarCarne() {
		if (cantCarnes<6 && enEspera) {
			cantCarnes++;
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

	public void vaciarCarnes() {
		cantCarnes = 0;
	}
	
	public void resetTemp() {
		temperatura = 0;
	}
	
	public void aumentarTemp() {
		temperatura+=5+((Math.random()-0.5)*4);
		System.out.println("Parrilla: " + temperatura);
	}

	public boolean isTapaCerrada() {
		return tapaCerrada;
	}

	public void setTapaCerrada(boolean tapaCerrada) {
		this.tapaCerrada = tapaCerrada;
	}
}