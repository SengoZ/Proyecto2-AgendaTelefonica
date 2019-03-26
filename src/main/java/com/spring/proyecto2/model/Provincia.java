package com.spring.proyecto2.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * 
 * @author Grupo 3: Amador Cáceres, Cesar Marcos, Andrés Gomez y Sheila García
 * 
 *         Realacionado con la tabla Provincias. 
 *         The persistent class for the direccion database table.
 *
 */

@Entity
@NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador de cada provincia
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idprovincia;

	private String provincia;

	/**
	 * bi-directional many-to-one association to Direccion
	 */
	@OneToMany(mappedBy = "provincia")
	private List<Direccion> direccions;

	public Provincia() {
	}

	public Provincia(String provincia) {
		this.provincia = provincia;
	}

	public int getIdprovincia() {
		return this.idprovincia;
	}

	public void setIdprovincia(int idprovincia) {
		this.idprovincia = idprovincia;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setProvincia(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setProvincia(null);

		return direccion;
	}

}