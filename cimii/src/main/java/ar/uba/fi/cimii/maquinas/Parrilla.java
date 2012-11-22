package ar.uba.fi.cimii.maquinas;

import ar.uba.fi.cimii.control.Alertas;
import ar.uba.fi.cimii.control.ControlProceso;

public class Parrilla {
	
	private static Parrilla INSTANCE = null;
	
	private int cantCarnes;
	
	private boolean enEspera;
	
	private boolean espCondimentacion;
	
	private int temperatura;
	
	private boolean tapaCerrada;
	
	private String estado;
	
	private Parrilla() {
		cantCarnes = 0;
		enEspera = true;
		temperatura = 0;
		estado="esperando";
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
		estado="calentando";
		temperatura+=5+((Math.random()-0.5)*4);
	}

	public boolean isTapaCerrada() {
		return tapaCerrada;
	}

	public void setTapaCerrada(boolean tapaCerrada) {
		this.tapaCerrada = tapaCerrada;
	}

	public boolean isEspCondimentacion() {
		return espCondimentacion;
	}

	public synchronized void setEspCondimentacion(boolean espCondimentacion) {
		this.espCondimentacion = espCondimentacion;
	}
	
	public void pasarACinta() {
		for (int i = 0; i < cantCarnes; i++) {
			if(Math.random() >= 0.1) {
				CintaTransportadora.getInstance().agregarCarne();
			} else {
				Alertas.getInstance().getAlertasAdmin().add(0, "Se perdió una carne al depositarla en la cinta transportadora");
				Alertas.getInstance().getAlertasCocinero().add(0, "Se perdió una carne al depositarla en la cinta transportadora");
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cantCarnes = 0;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void finProceso() {
		cantCarnes = 0;
		enEspera = true;
		temperatura = 0;
		estado="esperando";
		tapaCerrada = false;
	}
	
}