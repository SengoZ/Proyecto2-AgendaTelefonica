package com.spring.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "relacion_provincias")
public class Provincia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	// En principio la expresion de abajo no es necesaria
	// porque se va a dar una lista de provincias ya generada
	// por lo que no es necesario crear esa tabla
	// solo acceder a ella.
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProvincia;
	
	@Column(name="nombre_provincia")
	private String nombreProvincia;
	
	@JoinColumn(name= "direccion_id", referencedColumnName = "idDireccion")
	@OneToOne
	private Provincia provinciaId;
}
