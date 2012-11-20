package ar.uba.fi.cimii.control;

import java.util.Calendar;

import ar.uba.fi.cimii.maquinas.CintaTransportadora;
import ar.uba.fi.cimii.maquinas.Parrilla;
import ar.uba.fi.cimii.maquinas.TostadoraBases;
import ar.uba.fi.cimii.maquinas.TostadoraCorona;

public class Proceso {

	private Calendar horaInicio;
	
	private String estado;
	
	private int corPerdida;
	
	private int basePerdida;
	
	private int carnePerdida;

	public Proceso() {
		super();
		horaInicio = Calendar.getInstance();
		corPerdida = 0;
		basePerdida = 0;
		carnePerdida = 0;
		
		estado="Calentando parrillas y tostadoras";
		
		Parrilla parrilla = Parrilla.getInstance();
		TostadoraCorona tostCor = TostadoraCorona.getInstance();
		TostadoraBases tostBases = TostadoraBases.getInstance();
		CintaTransportadora cinta = CintaTransportadora.getInstance();
		Configuracion conf = Configuracion.getInstance();
		boolean faltaTemp = true;
		while (faltaTemp) {
			faltaTemp=false;
			if (parrilla.getTemperatura() < conf.getParrilaTempInf()) {
				faltaTemp = true;
				parrilla.aumentarTemp();
			}
			if (tostBases.getTemperatura() < conf.getTostadoraTempInf()) {
				faltaTemp = true;
				tostBases.aumentarTemp();
			}
			if (tostCor.getTemperatura() < conf.getTostadoraTempInf()) {
				faltaTemp = true;
				tostCor.aumentarTemp();
			}
			//Pasó un segundo
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if ((parrilla.getTemperatura() > conf.getParrilaTempSup()) 
					|| (tostBases.getTemperatura() > conf.getTostadoraTempSup())
					|| (tostCor.getTemperatura() > conf.getTostadoraTempSup())) {
				System.out.println("CONTROLA ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
			
			estado="Cocinando";
			
			//Doy por supuesto que el tiempo de la parrilla es superior
			parrilla.setTapaCerrada(true);
			tostBases.setTapaCerrada(true);
			tostCor.setTapaCerrada(true);
			
			try {
				Thread.sleep(conf.getSecTostadora()*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tostBases.setTapaCerrada(true);
			tostCor.setTapaCerrada(true);
			tostBases.resetTemp();
			tostCor.resetTemp();
			
			estado="Transfiriendo coronas a cinta";
			
			tostCor.pasarACinta();
			
			int aux = tostCor.getCantPanes() / 2;
			
			if (tostCor.getCantPanes() != 0 || cinta.getCantCoronas() == 0) {
				System.out.println("CONTROLA ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
			
			estado="Coronas en cinta";
			
			try {
				Thread.sleep((conf.getSecParrilla() - conf.getSecTostadora() - aux)*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
