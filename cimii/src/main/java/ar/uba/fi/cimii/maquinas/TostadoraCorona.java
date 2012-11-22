package ar.uba.fi.cimii.maquinas;

import ar.uba.fi.cimii.control.Alertas;
import ar.uba.fi.cimii.control.ControlProceso;

public class TostadoraCorona {
	
	private static TostadoraCorona INSTANCE = null;
	
	private int cantPanes;
	
	private boolean enEspera;
	
	private int temperatura;
	
	private boolean tapaCerrada;
	
	private String estado;
	
	private TostadoraCorona() {
		cantPanes = 0;
		enEspera = true;
		estado="esperando";
	}
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new TostadoraCorona();
        }
    }
	
	public static TostadoraCorona getInstance() {
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
	
	public void pasarACinta() {
		for (int i = 0; i < cantPanes; i++) {
			if(Math.random() >= 0.1) {
				CintaTransportadora.getInstance().agregarCorona();
			} else {
				Alertas.getInstance().getAlertasAdmin().add(0, "Se perdió una corona al depositarla en la cinta transportadora");
				Alertas.getInstance().getAlertasCocinero().add(0, "Se perdió una corona al depositarla en la cinta transportadora");
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cantPanes = 0;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void finProceso() {
		cantPanes = 0;
		enEspera = true;
		temperatura = 0;
		estado="esperando";
		tapaCerrada = false;
	}
}