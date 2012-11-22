package ar.uba.fi.cimii.maquinas;

import ar.uba.fi.cimii.control.Alertas;
import ar.uba.fi.cimii.control.Configuracion;
import ar.uba.fi.cimii.control.ControlProceso;

public class Dispenser {
	
	private static Dispenser INSTANCE = null;
	
	private int cantKetchup;
	
	private int cantMostaza;
	
	private int cantCebolla;
	
	private String estado;
	
	private Dispenser() {
		cantKetchup=20;
		cantMostaza=50;
		cantCebolla=100;
		estado="esperando";
	}
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new Dispenser();
        }
    }
	
	public static Dispenser getInstance() {
        createInstance();
        return INSTANCE;
    }
	
	public int getCantKetchup() {
		return cantKetchup;
	}

	public void setCantKetchup(int cantKetchup) {
		this.cantKetchup = cantKetchup;
	}

	public int getCantMostaza() {
		return cantMostaza;
	}

	public void setCantMostaza(int cantMostaza) {
		this.cantMostaza = cantMostaza;
	}

	public int getCantCebolla() {
		return cantCebolla;
	}

	public void setCantCebolla(int cantCebolla) {
		this.cantCebolla = cantCebolla;
	}

	public void detectarPanes() {
		estado="detectando panes";
		//Simulo el tiempo que va a tardar en llegar el pan a condimentación
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CintaTransportadora.getInstance().setAvanzando(false);
		CintaTransportadora.getInstance().setEstado("detenida");
		estado="condimentando";
		ControlProceso.getInstance().getProcesoActual().setEstado("Condimentando");
		for (int i = 0; i < CintaTransportadora.getInstance().getCantCoronas(); i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				cantKetchup-=Configuracion.getInstance().getOnzaKetchup();
				cantMostaza-=Configuracion.getInstance().getOnzaMostaza();
				cantCebolla-=Configuracion.getInstance().getOnzaCebolla();
				if (cantKetchup < 0 || cantMostaza < 0 || cantCebolla < 0) {
					Alertas.getInstance().getAlertasAdmin().add(0, "Condimentos insuficientes, revisar");
					Alertas.getInstance().getAlertasCocinero().add(0, "Condimentos insuficientes, revisar");
					throw new RuntimeException();
				}
		}
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void finProceso() {
		estado="esperando";
	}
	
}
