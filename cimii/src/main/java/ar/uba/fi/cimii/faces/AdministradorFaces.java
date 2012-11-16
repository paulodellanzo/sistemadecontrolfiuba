package ar.uba.fi.cimii.faces;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "admin")
public class AdministradorFaces {

	private String value = "Bienvenido administrador";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}