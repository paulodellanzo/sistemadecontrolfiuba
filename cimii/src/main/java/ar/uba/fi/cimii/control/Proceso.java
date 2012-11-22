package ar.uba.fi.cimii.control;

import java.util.Calendar;

import ar.uba.fi.cimii.maquinas.CintaTransportadora;
import ar.uba.fi.cimii.maquinas.Dispenser;
import ar.uba.fi.cimii.maquinas.Parrilla;
import ar.uba.fi.cimii.maquinas.TostadoraBases;
import ar.uba.fi.cimii.maquinas.TostadoraCorona;

public class Proceso {

	private Calendar horaInicio;
	private Calendar horaFin;
	
	private String estado;
	
	Parrilla parrilla = Parrilla.getInstance();
	TostadoraCorona tostCor = TostadoraCorona.getInstance();
	TostadoraBases tostBases = TostadoraBases.getInstance();
	CintaTransportadora cinta = CintaTransportadora.getInstance();
	Dispenser dispenser = Dispenser.getInstance();
	Configuracion conf = Configuracion.getInstance();
	Alertas alertas = Alertas.getInstance();

	public Proceso() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Calendar getHoraInicio() {
		return horaInicio;
	}
	
	public Calendar getHoraFin() {
		return horaFin;
	}
	
	public int getSegundosProceso() {
		long timestampHasta = Calendar.getInstance().getTimeInMillis();
		if(horaFin != null) {
			timestampHasta = horaFin.getTimeInMillis();
		}
		
		return (int) ((timestampHasta - horaInicio.getTimeInMillis())/1000);
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void comenzar() throws InterruptedException {
		try {
				
			
			horaInicio = Calendar.getInstance();
			
			estado="Calentando parrillas y tostadoras";
			
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
				Thread.sleep(1000);
				if ((parrilla.getTemperatura() > conf.getParrilaTempSup()) 
						|| (tostBases.getTemperatura() > conf.getTostadoraTempSup())
						|| (tostCor.getTemperatura() > conf.getTostadoraTempSup())) {
					alertas.getAlertasAdmin().add(0, "Exceso de temperatura en maquinarias, proceso detenido");
					alertas.getAlertasCocinero().add(0, "Exceso de temperatura en maquinarias, proceso detenido");
					throw new RuntimeException();
				}
			}
			parrilla.setEstado("Cocinando");
			tostBases.setEstado("Cocinando");
			tostCor.setEstado("Cocinando");
			estado="Cocinando";
			
			//Doy por supuesto que el tiempo de la parrilla es superior
			parrilla.setTapaCerrada(true);
			tostBases.setTapaCerrada(true);
			tostCor.setTapaCerrada(true);
			
			Thread.sleep(conf.getSecTostadora()*1000);
			
			tostBases.setTapaCerrada(false);
			tostCor.setTapaCerrada(false);
			tostBases.resetTemp();
			tostCor.resetTemp();
			tostBases.setEstado("esperando señal");
			tostCor.setEstado("Transfiriendo coronas a cinta");
			
			estado="Transfiriendo coronas a cinta";
			//Lo que va a hacer la parrilla en paralelo
			new Thread(
				new Runnable() {
					public void run() {
						try {
							Thread.sleep((Configuracion.getInstance().getSecParrilla() - Configuracion.getInstance().getSecTostadora())*1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Parrilla.getInstance().setTapaCerrada(false);
						Parrilla.getInstance().resetTemp();
						Parrilla.getInstance().setEstado("esperando coronas");
						Parrilla.getInstance().setEspCondimentacion(true);
						while(Parrilla.getInstance().isEspCondimentacion()) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			).start();
			
			tostCor.pasarACinta();
			
			if (tostCor.getCantPanes() != 0 || cinta.getCantCoronas() == 0) {
				alertas.getAlertasAdmin().add(0, "Problema al transferir coronas a cinta: quedan panes en tostadora");
				alertas.getAlertasCocinero().add(0, "Problema al transferir coronas a cinta: quedan panes en tostadora");
				throw new RuntimeException();
			}
			
			tostCor.setEstado("finalizado");
			
			cinta.setEstado("con coronas");
			
			estado="Coronas en cinta";
			
			cinta.setAvanzando(true);
			
			dispenser.detectarPanes();
			
			estado="Llevando coronas condimentadas";
			
			cinta.setEstado("con coronas");
			cinta.setAvanzando(true);
			
			Thread.sleep(5000);
			
			//Se le avisa a la parrilla que ya puede dejar las carnes en la cinta y termina el otro thread
			parrilla.setEspCondimentacion(false);
			parrilla.setEstado("Transfiriendo carnes");
			estado="Transfiriendo carnes a cinta";
			
			parrilla.pasarACinta();
			
			parrilla.setEstado("finalizado");
			estado="Transfiriendo bases a cinta";
			
			tostBases.setEstado("Transfiriendo bases");
			tostBases.pasarACinta();
			
			tostBases.setEstado("finalizado");
			estado="Finalizado";
			horaFin=Calendar.getInstance();
		} catch (RuntimeException e) {
			estado="Detenido";
		}
	}

}
