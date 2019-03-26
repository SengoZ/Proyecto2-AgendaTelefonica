package com.spring.proyecto2.model;

public class Contacto {
	
	private Persona pers;
	private Direccion dir;
	private Telefono tel;
	private Provincia prov;
	public Contacto() {
		super();
	}

	public Contacto(Persona pers, Direccion dir, Telefono tel, Provincia prov) {
		super();
		this.pers = pers;
		this.dir = dir;
		this.tel = tel;
		this.prov=prov;
	}

	public Persona getPers() {
		return pers;
	}

	public void setPers(Persona pers) {
		this.pers = pers;
	}

	public Direccion getDir() {
		return dir;
	}

	public void setDir(Direccion dir) {
		this.dir = dir;
	}

	public Telefono getTel() {
		return tel;
	}

	public void setTel(Telefono tel) {
		this.tel = tel;
	}
	
	public void setProv(Provincia prov) {
		this.prov = prov;
	}
	
	public Provincia getProv() {
		return prov;
	}

	@Override
	public String toString() {
		return "Contacto [pers=" + pers + ", dir=" + dir + ", tel=" + tel + "]";
	}
	
	
	
}
