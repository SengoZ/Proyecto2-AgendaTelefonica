package com.spring.proyecto2.model;

import java.util.List;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Grupo 3: Amador Cáceres, Cesar Marcos, Andrés Gomez y Sheila García
 *
 */

//Se le da una identidad a la clase y se define el nombre de la tabla en la que se encuentran los objetos de este tipo.

@Entity
@Table(name = "persona")

public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Se utiliza OneToMany para relacionar una persona (mapeado por el ID de la
	// persona) con varios números de teléfono.

	@OneToMany(mappedBy = "personaId")
	private List<Telefono> listaTelefonos;

	// Se utiliza OneToOne para relacionar una persona (mapeado por el ID de la
	// persona) con una dirección.

	@OneToOne(mappedBy = "personaId") // He utilizado persona id para telefonos y direcciones puede ser que de
										// problema al ejecutarlo, para eso cambiar el nombre
	private Direccion direccion;

	// Se le da una identidad a la ID de la persona que será autoincremental.
	// También se hace referencia a las columnas de la tabla que guardará cada
	// atributo del objeto.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "correo")
	private String correo;

	public List<Telefono> getListaTelefonos() {
		return listaTelefonos;
	}
	// Se realizan Getter/Setter de todos los parámetros.

	public void setListaTelefonos(List<Telefono> listaTelefonos) {
		this.listaTelefonos = listaTelefonos;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	// Se realizan tanto el constructor vacío como el constructor con los atributos
	// que definen al objeto.

	public Persona() {
		super();
	}

	public Persona(List<Telefono> listaTelefonos, Direccion direccion, Integer id, String nombre, String apellido,
			String correo) {
		super();
		this.listaTelefonos = listaTelefonos;
		this.direccion = direccion;
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
	}

	// Se realiza el ToString

	@Override
	public String toString() {
		return "Persona [listaTelefonos=" + listaTelefonos + ", direccion=" + direccion + ", id=" + id + ", nombre="
				+ nombre + ", apellido=" + apellido + ", correo=" + correo + "]";
	}

}