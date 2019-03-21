package com.spring.proyecto2.model;

import java.util.Date;
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

/**
 * Se le da una identidad a la clase y se define el nombre de la tabla en la que
 * se encuentran los objetos de este tipo.
 */

@Entity
@Table(name = "persona")

public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Se utiliza OneToMany para relacionar una persona (mapeado por el ID de la
	 * persona) con varios números de teléfono.
	 */

	@OneToMany(mappedBy = "personaId") // no existe en la tabla de personas ni telefono ni direccion, no sé si funcionará así. revisar.
	private List<Telefono> listaTelefonos;

	/**
	 * Se utiliza OneToOne para relacionar una persona (mapeado por el ID de la
	 * persona) con una dirección.
	 */

	@OneToOne(mappedBy = "personaId") // He utilizado persona id para telefonos y direcciones puede ser que de
										// problema al ejecutarlo, para eso cambiar el nombre
	private Direccion direccion;

	/**
	 * Se le da una identidad a la ID de la persona que será autoincremental.
	 * También se hace referencia a las columnas de la tabla que guardará cada
	 * atributo del objeto.
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpersona")
	private Integer idpersona;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido1")
	private String apellido1;

	@Column(name = "apellido2")
	private String apellido2;

	@Column(name = "dni")
	private String dni;

	@Column(name = "fechanacimiento")
	private Date fechanacimiento;

	public List<Telefono> getListaTelefonos() {
		return listaTelefonos;
	}

	/**
	 * Se realizan Getter/Setter de todos los parámetros.
	 */

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public void setListaTelefonos(List<Telefono> listaTelefonos) {
		this.listaTelefonos = listaTelefonos;
	}

	/**
	 * Se realizan tanto el constructor vacío como el constructor con los atributos
	 * que definen al objeto.
	 */

	public Persona() {
		super();
	}

	public Persona(Integer idpersona, String nombre,
			String apellido1, String apellido2, String dni, Date fechanacimiento) {
		super();
		this.idpersona = idpersona;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.fechanacimiento = fechanacimiento;
	}

	/**
	 * Se realiza el ToString
	 */
	@Override
	public String toString() {
		return "Persona [idpersona=" + idpersona
				+ ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", dni=" + dni
				+ ", fechanacimiento=" + fechanacimiento + "]";
	}

}