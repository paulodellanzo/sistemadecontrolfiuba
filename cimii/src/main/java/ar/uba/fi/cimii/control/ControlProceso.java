package ar.uba.fi.cimii.control;

import ar.uba.fi.cimii.maquinas.CintaTransportadora;
import ar.uba.fi.cimii.maquinas.Dispenser;
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
			TostadoraBases.getInstance().setEnEspera(false);
			TostadoraCorona.getInstance().setEnEspera(false);
			Parrilla.getInstance().setEnEspera(false);
			setProcesoActual(new Proceso());
			
			new Thread(
				new Runnable() {
					public void run() {
						try {
							procesoActual.comenzar();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			).start();
		}
	}
	
	public void finalizarProcesoActual() {
		try {
			if (procesoActual.getEstado().equals("Finalizado") || procesoActual.getEstado().equals("Detenido")) {
				Parrilla.getInstance().finProceso();
				TostadoraCorona.getInstance().finProceso();
				TostadoraBases.getInstance().finProceso();
				CintaTransportadora.getInstance().finProceso();
				Dispenser.getInstance().finProceso();
				procesoActual = null;
			} else {
				Alertas.getInstance().getAlertasCocinero().add(0, "No se puede detener el proceso");
			}
		} catch (NullPointerException e) {
			Alertas.getInstance().getAlertasCocinero().add(0, "No hay ningún proceso en ejecución");
		}
	}
	
}
