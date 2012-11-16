package ar.uba.fi.cimii.faces;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "cocinero")
public class CocineroFaces {

	private String value = "Vista del cocinero";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}