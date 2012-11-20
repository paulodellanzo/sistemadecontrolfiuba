package ar.uba.fi.cimii.control;

import ar.uba.fi.cimii.maquinas.Parrilla;
import ar.uba.fi.cimii.maquinas.TostadoraBases;
import ar.uba.fi.cimii.maquinas.TostadoraCorona;

public class ControlProceso {
	
	private static ControlProceso INSTANCE = null;
	
	private Proceso procesoActual;
	
	private ControlProceso() {
		
	}
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new ControlProceso();
        }
    }
	
	public static ControlProceso getInstance() {
        createInstance();
        return INSTANCE;
    }
	
	public synchronized Proceso getProcesoActual() {
		return procesoActual;
	}

	public synchronized void setProcesoActual(Proceso procesoActual) {
		this.procesoActual = procesoActual;
	}

	public void comenzarProceso() {
		if(TostadoraBases.getInstance().getCantPanes() == TostadoraCorona.getInstance().getCantPanes()
				&& TostadoraCorona.getInstance().getCantPanes() == Parrilla.getInstance().getCantCarnes()) {
			System.out.println("Comienza proceso");
			TostadoraBases.getInstance().vaciarPanes();
			TostadoraCorona.getInstance().vaciarPanes();
			Parrilla.getInstance().vaciarCarnes();
			TostadoraBases.getInstance().setEnEspera(false);
			TostadoraCorona.getInstance().setEnEspera(false);
			Parrilla.getInstance().setEnEspera(false);
			
			new Thread(
				new Runnable() {
					public void run() {
						setProcesoActual(new Proceso());
					}
				}
			).start();
		}
	}
	
}
