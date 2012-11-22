package ar.uba.fi.cimii.maquinas;

public class CintaTransportadora {
	
	private static CintaTransportadora INSTANCE = null;
	
	private int cantCoronas;
	
	private int cantBases;
	
	private int cantCarnes;
	
	private boolean avanzando;
	
	private String estado;
	
	private CintaTransportadora() {
		cantCoronas = 0;
		cantBases = 0;
		cantCarnes = 0;
		estado="esperando";
		avanzando = false;
	}
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new CintaTransportadora();
        }
    }
	
	public static CintaTransportadora getInstance() {
        createInstance();
        return INSTANCE;
    }
	
	public void agregarCorona() {
		cantCoronas++;
	}
	
	public void agregarBase() {
		cantBases++;
	}
	
	public void agregarCarne() {
		cantCarnes++;
	}

	public int getCantCoronas() {
		return cantCoronas;
	}

	public int getCantBases() {
		return cantBases;
	}

	public int getCantCarnes() {
		return cantCarnes;
	}

	public boolean isAvanzando() {
		return avanzando;
	}

	public void setAvanzando(boolean avanzando) {
		this.avanzando = avanzando;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void finProceso() {
		cantCoronas = 0;
		cantBases = 0;
		cantCarnes = 0;
		estado="esperando";
		avanzando = false;
	}
}
