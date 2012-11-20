package ar.uba.fi.cimii.maquinas;

import ar.uba.fi.cimii.control.ControlProceso;

public class TostadoraCorona {
	
	private static TostadoraCorona INSTANCE = null;
	
	private int cantPanes;
	
	private boolean enEspera;
	
	private int temperatura;
	
	private boolean tapaCerrada;
	
	private TostadoraCorona() {
		cantPanes = 0;
		enEspera = true;
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
		temperatura+=5+((Math.random()-0.5)*4);
		System.out.println("Tostadora corona: " + temperatura);
	}
	
	public boolean isTapaCerrada() {
		return tapaCerrada;
	}

	public void setTapaCerrada(boolean tapaCerrada) {
		this.tapaCerrada = tapaCerrada;
	}
	
	public void pasarACinta() {
		for (int i = 0; i < cantPanes; i++) {
			CintaTransportadora.getInstance().agregarCorona();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cantPanes = 0;
	}
}