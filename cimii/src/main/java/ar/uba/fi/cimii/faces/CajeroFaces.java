package ar.uba.fi.cimii.faces;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "cajero")
public class CajeroFaces {

	private String value = "Vista del cajero";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}