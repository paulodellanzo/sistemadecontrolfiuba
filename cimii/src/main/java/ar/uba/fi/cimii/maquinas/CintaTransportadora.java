package ar.uba.fi.cimii.maquinas;

public class CintaTransportadora {
	
	private static CintaTransportadora INSTANCE = null;
	
	private int cantCoronas;
	
	private int cantBases;
	
	private int cantCarnes;
	
	private CintaTransportadora() {
		cantCoronas = 1;
		cantBases = 0;
		cantCarnes = 0;
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
}
