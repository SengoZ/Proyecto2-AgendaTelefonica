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
@Table(name = "direccion")

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
	private Integer iddireccion;

	@Column(name = "direccion")
	private String direccion;
	@Column(name = "codpostal")
	private int codpostal;
	@Column(name = "localidad")
	private String localidad;
	@Column(name = "idprovincia")
	private int idprovincia;
	@Column(name = "idpersona")
	private int idpersona;

	// Se utiliza JoinColumn para relacionar las tablas de Persona y Dirección a
	// través del ID de la persona utilizando OneToOne

	@JoinColumn(name = "persona_id", referencedColumnName = "idpersona")
	@OneToOne
	private Persona personaId;

	// Se utiliza OneToOne para relacionar una dirección (mapeado por el ID de la
	// provincia) con una provincia.

	@OneToOne(mappedBy = "provinciaId")
	private Provincia provincia;

	// Se realizan Getter/Setter de todos los parámetros.
	public Integer getIddireccion() {
		return iddireccion;
	}

	public void setIddireccion(Integer iddireccion) {
		this.iddireccion = iddireccion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCodpostal() {
		return codpostal;
	}

	public void setCodpostal(int codpostal) {
		this.codpostal = codpostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getIdprovincia() {
		return idprovincia;
	}

	public void setIdprovincia(int idprovincia) {
		this.idprovincia = idprovincia;
	}

	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
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

	public Direccion(Integer iddireccion, String direccion, int codpostal, String localidad, int idprovincia,
			int idpersona, Persona personaId, Provincia provincia) {
		super();
		this.iddireccion = iddireccion;
		this.direccion = direccion;
		this.codpostal = codpostal;
		this.localidad = localidad;
		this.idprovincia = idprovincia;
		this.idpersona = idpersona;
		this.personaId = personaId;
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Direccion [iddireccion=" + iddireccion + ", direccion=" + direccion + ", codpostal=" + codpostal
				+ ", localidad=" + localidad + ", idprovincia=" + idprovincia + ", idpersona=" + idpersona
				+ ", personaId=" + personaId + ", provincia=" + provincia + "]";
	}

	// Se realiza el ToString


}
