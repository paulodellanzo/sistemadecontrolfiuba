package ar.uba.fi.cimii.faces;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Min;

import ar.uba.fi.cimii.control.Alertas;
import ar.uba.fi.cimii.control.Configuracion;
import ar.uba.fi.cimii.maquinas.Bebidas;

@SessionScoped
@ManagedBean(name = "admin")
public class AdministradorFaces {
	
	Configuracion conf;
	
	Bebidas bebidas;
	
	private List<String> alertas;
	
	public AdministradorFaces() {
		super();
		conf = Configuracion.getInstance();
		bebidas = Bebidas.getInstance();
	}

	public int getParrilaTempSup() {
		return conf.getParrilaTempSup();
	}

	public void setParrilaTempSup(int parrilaTempSup) {
		conf.setParrilaTempSup(parrilaTempSup);
	}

	public int getParrilaTempInf() {
		return conf.getParrilaTempInf();
	}

	public void setParrilaTempInf(int parrilaTempInf) {
		conf.setParrilaTempInf(parrilaTempInf);
	}

	public int getCarneTempCotaInf() {
		return conf.getCarneTempCotaInf();
	}

	public void setCarneTempCotaInf(int carneTempCotaInf) {
		conf.setCarneTempCotaInf(carneTempCotaInf);
	}

	public int getCarneTempCotaSup() {
		return conf.getCarneTempCotaSup();
	}

	public void setCarneTempCotaSup(int carneTempCotaSup) {
		conf.setCarneTempCotaSup(carneTempCotaSup);
	}

	public int getTostadoraTempSup() {
		return conf.getTostadoraTempSup();
	}

	public void setTostadoraTempSup(int tostadoraTempSup) {
		conf.setTostadoraTempSup(tostadoraTempSup);
	}

	public int getTostadoraTempInf() {
		return conf.getTostadoraTempInf();
	}

	public void setTostadoraTempInf(int tostadoraTempInf) {
		conf.setTostadoraTempInf(tostadoraTempInf);
	}

	public int getPanTempCotaInf() {
		return conf.getPanTempCotaInf();
	}

	public void setPanTempCotaInf(int panTempCotaInf) {
		conf.setPanTempCotaInf(panTempCotaInf);
	}

	public int getPanTempCotaSup() {
		return conf.getPanTempCotaSup();
	}

	public void setPanTempCotaSup(int panTempCotaSup) {
		conf.setPanTempCotaSup(panTempCotaSup);
	}

	public int getOnzaKetchup() {
		return conf.getOnzaKetchup();
	}

	public void setOnzaKetchup(int onzaKetchup) {
		conf.setOnzaKetchup(onzaKetchup);
	}

	public int getOnzaMostaza() {
		return conf.getOnzaMostaza();
	}

	public void setOnzaMostaza(int onzaMostaza) {
		conf.setOnzaMostaza(onzaMostaza);
	}

	public int getOnzaCebolla() {
		return conf.getOnzaCebolla();
	}

	public void setOnzaCebolla(int onzaCebolla) {
		conf.setOnzaCebolla(onzaCebolla);
	}
	
	public int getSecParrilla() {
		return conf.getSecParrilla();
	}

	public void setSecParrilla(int secParrilla) {
		conf.setSecParrilla(secParrilla);
	}

	public int getSecTostadora() {
		return conf.getSecTostadora();
	}

	public void setSecTostadora(int secTostadora) {
		conf.setSecTostadora(secTostadora);
	}

	public void guardar() {
	}
	
	public Bebidas getBebidas() {
		return bebidas;
	}
	
	public void updateAlertas() {
		alertas = Alertas.getInstance().getAlertasAdmin();
	}
	
	public void clearAlertas() {
		Alertas.getInstance().getAlertasAdmin().clear();
	}

	public List<String> getAlertas() {
		return alertas;
	}

	public void setAlertas(List<String> alertas) {
		this.alertas = alertas;
	}
	
}