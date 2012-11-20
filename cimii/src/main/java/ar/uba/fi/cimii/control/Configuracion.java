package ar.uba.fi.cimii.control;

public class Configuracion {
	
	private static Configuracion INSTANCE = null;
	
	private int parrilaTempInf;
	private int parrilaTempSup;
	private int secParrilla;
	private int carneTempCotaInf;
	private int carneTempCotaSup;
	private int tostadoraTempInf;
	private int tostadoraTempSup;
	private int secTostadora;
	private int panTempCotaInf;
	private int panTempCotaSup;
	private int onzaKetchup;
	private int onzaMostaza;
	private int onzaCebolla;
	
	
	private Configuracion() {
		parrilaTempInf = 218;
		parrilaTempSup = 238;
		secParrilla = 42;
		carneTempCotaInf = 100;
		carneTempCotaSup = 120;
		tostadoraTempInf = 216;
		tostadoraTempSup = 228;
		secTostadora = 20;
		panTempCotaInf = 50;
		panTempCotaSup = 70;
		onzaKetchup = 2;
		onzaMostaza = 1;
		onzaCebolla = 5;
	}
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new Configuracion();
        }
    }
	
	public static Configuracion getInstance() {
        createInstance();
        return INSTANCE;
    }

	public int getParrilaTempInf() {
		return parrilaTempInf;
	}

	public void setParrilaTempInf(int parrilaTempInf) {
		this.parrilaTempInf = parrilaTempInf;
	}

	public int getParrilaTempSup() {
		return parrilaTempSup;
	}

	public void setParrilaTempSup(int parrilaTempSup) {
		this.parrilaTempSup = parrilaTempSup;
	}

	public int getSecParrilla() {
		return secParrilla;
	}

	public void setSecParrilla(int secParrilla) {
		this.secParrilla = secParrilla;
	}

	public int getCarneTempCotaInf() {
		return carneTempCotaInf;
	}

	public void setCarneTempCotaInf(int carneTempCotaInf) {
		this.carneTempCotaInf = carneTempCotaInf;
	}

	public int getCarneTempCotaSup() {
		return carneTempCotaSup;
	}

	public void setCarneTempCotaSup(int carneTempCotaSup) {
		this.carneTempCotaSup = carneTempCotaSup;
	}

	public int getTostadoraTempInf() {
		return tostadoraTempInf;
	}

	public void setTostadoraTempInf(int tostadoraTempInf) {
		this.tostadoraTempInf = tostadoraTempInf;
	}

	public int getTostadoraTempSup() {
		return tostadoraTempSup;
	}

	public void setTostadoraTempSup(int tostadoraTempSup) {
		this.tostadoraTempSup = tostadoraTempSup;
	}

	public int getSecTostadora() {
		return secTostadora;
	}

	public void setSecTostadora(int secTostadora) {
		this.secTostadora = secTostadora;
	}

	public int getPanTempCotaInf() {
		return panTempCotaInf;
	}

	public void setPanTempCotaInf(int panTempCotaInf) {
		this.panTempCotaInf = panTempCotaInf;
	}

	public int getPanTempCotaSup() {
		return panTempCotaSup;
	}

	public void setPanTempCotaSup(int panTempCotaSup) {
		this.panTempCotaSup = panTempCotaSup;
	}

	public int getOnzaKetchup() {
		return onzaKetchup;
	}

	public void setOnzaKetchup(int onzaKetchup) {
		this.onzaKetchup = onzaKetchup;
	}

	public int getOnzaMostaza() {
		return onzaMostaza;
	}

	public void setOnzaMostaza(int onzaMostaza) {
		this.onzaMostaza = onzaMostaza;
	}

	public int getOnzaCebolla() {
		return onzaCebolla;
	}

	public void setOnzaCebolla(int onzaCebolla) {
		this.onzaCebolla = onzaCebolla;
	}
	
}
