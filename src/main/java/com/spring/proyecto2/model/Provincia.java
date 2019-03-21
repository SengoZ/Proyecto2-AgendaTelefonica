package com.spring.proyecto2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "provincia")
public class Provincia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Se le da una identidad al iD de la provincia y se indican las columnas
	// respectivas de cada atributo

	@Id
	// En principio la expresion de abajo no es necesaria
	// porque se va a dar una lista de provincias ya generada
	// por lo que no es necesario crear esa tabla
	// solo acceder a ella.
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProvincia;

	@Column(name = "provincia")
	private String provincia;

	// Se utiliza JoinColumn para relacionar las tablas de Dirección y Provincia a
	// través del ID de la dirección utilizando OneToOne

	@JoinColumn(name = "direccion_id", referencedColumnName = "idDireccion")
	@OneToOne
	private Provincia provinciaId;

	// Se realizan Getter/Setter de todos los parámetros.

	public Integer getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Provincia getProvinciaId() {
		return provinciaId;
	}

	public void setProvinciaId(Provincia provinciaId) {
		this.provinciaId = provinciaId;
	}

	// Se realizan tanto el constructor vacío como el constructor con los atributos
	// que definen al objeto.

	public Provincia() {
		super();
	}

	public Provincia(Integer idProvincia, String provincia, Provincia provinciaId) {
		super();
		this.idProvincia = idProvincia;
		this.provincia = provincia;
		this.provinciaId = provinciaId;
	}

	// Se realiza el ToString

	@Override
	public String toString() {
		return "Provincia [idProvincia=" + idProvincia + ", nombreProvincia=" + provincia + ", provinciaId="
				+ provinciaId + "]";
	}

}