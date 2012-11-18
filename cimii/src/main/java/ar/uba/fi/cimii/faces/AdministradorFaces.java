package ar.uba.fi.cimii.faces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Min;

@SessionScoped
@ManagedBean(name = "admin")
public class AdministradorFaces {

	//Falta validar
	private int parrilaTempSup = 100;
	private int parrilaTempInf = 100;
	private int secParrilla = 50;
	private int carneTempCotaInf = 100;
	private int carneTempCotaSup = 100;
	private int tostadoraTempSup = 100;
	private int tostadoraTempInf = 100;
	private int secTostadora = 50;
	private int panTempCotaInf = 100;
	private int panTempCotaSup = 100;
	private int onzaKetchup = 100;
	private int onzaMostaza = 100;
	private int onzaCebolla = 100;
	
	public AdministradorFaces() {
		super();
	}

	public int getParrilaTempSup() {
		return parrilaTempSup;
	}

	public void setParrilaTempSup(int parrilaTempSup) {
		this.parrilaTempSup = parrilaTempSup;
	}

	public int getParrilaTempInf() {
		return parrilaTempInf;
	}

	public void setParrilaTempInf(int parrilaTempInf) {
		this.parrilaTempInf = parrilaTempInf;
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

	public int getTostadoraTempSup() {
		return tostadoraTempSup;
	}

	public void setTostadoraTempSup(int tostadoraTempSup) {
		this.tostadoraTempSup = tostadoraTempSup;
	}

	public int getTostadoraTempInf() {
		return tostadoraTempInf;
	}

	public void setTostadoraTempInf(int tostadoraTempInf) {
		this.tostadoraTempInf = tostadoraTempInf;
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
	
	public int getSecParrilla() {
		return secParrilla;
	}

	public void setSecParrilla(int secParrilla) {
		this.secParrilla = secParrilla;
	}

	public int getSecTostadora() {
		return secTostadora;
	}

	public void setSecTostadora(int secTostadora) {
		this.secTostadora = secTostadora;
	}

	public void guardar() {
	}
	
}