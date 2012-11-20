package ar.uba.fi.cimii.maquinas;

public class Dispenser {
	
	private static Dispenser INSTANCE = null;
	
	private Dispenser() {
		
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
	
}
