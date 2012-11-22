package ar.uba.fi.cimii.maquinas;

import java.util.ArrayList;
import java.util.List;

import ar.uba.fi.cimii.control.Alertas;
import ar.uba.fi.cimii.control.Configuracion;
import ar.uba.fi.cimii.control.ControlProceso;
import ar.uba.fi.cimii.domain.entities.Pedido;

public class Bebidas {
	
	private static Bebidas INSTANCE = null;
	
	private String estado;
	
	private int cantVasos;
	
	private int porcentajeServido;
	
	private List<Pedido> pedidoBebidas;
	
	private Bebidas() {
		pedidoBebidas = new ArrayList<Pedido>();
		cantVasos = 100;
		estado="Esperando pedido";
		new Thread(
			new Runnable() {
				public void run() {
					while(true) {
						chequear();
					}
				}
			}
		).start();
	}
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new Bebidas();
        }
    }
	
	public static Bebidas getInstance() {
        createInstance();
        return INSTANCE;
    }
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Pedido> getPedidoBebidas() {
		return pedidoBebidas;
	}

	public void setPedidoBebidas(List<Pedido> pedidoBebidas) {
		this.pedidoBebidas = pedidoBebidas;
	}
	
	public synchronized void chequear() {
		while(pedidoBebidas.isEmpty()) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Pedido pedido = pedidoBebidas.get(0);
		estado="Sirviendo: " + pedido.getDescripcion();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		estado="Colocando vaso";
		cantVasos--;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Math.random()<0.2) {
			Alertas.getInstance().getAlertasCajero().add(0, "Se perdió un vaso");
			estado="Error, reacomodando";
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		porcentajeServido = 0;
		estado="Sirviendo " + pedido.getDescripcion();
		while(porcentajeServido<100) {
			porcentajeServido+=10;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (Math.random()<0.3) {
			Alertas.getInstance().getAlertasCajero().add(0, "Derrame, cantidad de bebida excedida");
			estado="Error, reacomodando";
			porcentajeServido=0;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		estado="Desplazando vaso de " + pedido.getDescripcion();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pedidoBebidas.remove(0);
		porcentajeServido=0;
		estado="Chequeando pedidos";
	}

	public int getCantVasos() {
		return cantVasos;
	}

	public void setCantVasos(int cantVasos) {
		this.cantVasos = cantVasos;
	}

	public int getPorcentajeServido() {
		return porcentajeServido;
	}

	public void setPorcentajeServido(int procentajeServido) {
		this.porcentajeServido = procentajeServido;
	}
	
}
