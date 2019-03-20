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

@Entity
@Table(name = "relacion_telefonos")
public class Telefono implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer idTelefono;
		@Column(name="numero")
		private int numero;
		
		@JoinColumn(name= "persona_id", referencedColumnName = "id")
		@OneToOne
		private Persona personaId;
	
}
