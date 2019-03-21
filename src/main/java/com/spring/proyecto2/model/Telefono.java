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
@Table(name = "telefono")
public class Telefono implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	// Se le da una identidad a la ID del teléfono que será autoincremental.
	// También se hace referencia a las columnas de la tabla que guardarán cada
	// atributo del objeto.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTelefono;
	@Column(name = "telefono")
	private int telefono;

	// Se utiliza JoinColumn para relacionar las tablas de Persona y Telefonos a
	// través del ID de la persona utilizando OneToOne

	@JoinColumn(name = "persona_id", referencedColumnName = "idpersona")
	@OneToOne
	private Persona personaId;

	// Se realizan Getter/Setter de todos los parámetros.

	public Integer getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(Integer idTelefono) {
		this.idTelefono = idTelefono;
	}


	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Persona getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Persona personaId) {
		this.personaId = personaId;
	}

	// Se realizan tanto el constructor vacío como el constructor con los atributos
	// que definen al objeto.

	public Telefono() {
		super();
	}

	public Telefono(Integer idTelefono, int telefono, Persona personaId) {
		super();
		this.idTelefono = idTelefono;
		this.telefono = telefono;
		this.personaId = personaId;
	}

	@Override
	public String toString() {
		return "Telefono [idTelefono=" + idTelefono + ", telefono=" + telefono + ", personaId=" + personaId + "]";
	}
	
	

	// Se realiza el ToString

	

}