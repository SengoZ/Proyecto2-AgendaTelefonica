package com.spring.proyecto2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Grupo 3: Amador Cáceres, Cesar Marcos, Andrés Gomez y Sheila García
 *
 */

//Se le da una identidad a la clase y se define el nombre de la tabla en la que se encuentran los objetos de este tipo.

@Entity
@Table(name = "relacion_direcciones")

public class Direccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Se le da una identidad a la ID de la persona que será autoincremental.
	// También se hace referencia a las columnas de la tabla que guardará cada
	// atributo del objeto.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDireccion;

	@Column(name = "calle")
	private String calle;

	@Column(name = "numero_calle")
	private int numeroCalle;

	// Se utiliza JoinColumn para relacionar las tablas de Persona y Dirección a
	// través del ID de la persona utilizando OneToOne
	@JoinColumn(name = "persona_id", referencedColumnName = "id")
	@OneToOne
	private Persona personaId;
	// Se utiliza OneToOne para relacionar una dirección (mapeado por el ID de la
	// provincia) con una provincia.
	@OneToOne(mappedBy = "provinciaId")
	private Provincia provincia;

	// Se realizan Getter/Setter de todos los parámetros.

	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumeroCalle() {
		return numeroCalle;
	}

	public void setNumeroCalle(int numeroCalle) {
		this.numeroCalle = numeroCalle;
	}

	public Persona getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Persona personaId) {
		this.personaId = personaId;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	// Se realizan tanto el constructor vacío como el constructor con los atributos
	// que definen al objeto.

	public Direccion() {
		super();
	}

	public Direccion(Integer idDireccion, String calle, int numeroCalle, Persona personaId, Provincia provincia) {
		super();
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.numeroCalle = numeroCalle;
		this.personaId = personaId;
		this.provincia = provincia;
	}

	// Se realiza el ToString
	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", calle=" + calle + ", numeroCalle=" + numeroCalle
				+ ", personaId=" + personaId + ", provincia=" + provincia + "]";
	}

}
