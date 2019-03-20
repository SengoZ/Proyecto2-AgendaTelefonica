/**
 * 
 */
package com.spring.model.services;

import java.util.List;

import com.spring.model.Persona;

/**
 * @author Sheila Garcia, Cesar Marcos, Amador Caceres, Andres Gomez
 * @version 1.0
 * 
 * Interfaz de Services de la aplicación de Agenda telefónica
 *
 */
public interface AgendaService {

	/**
	 * Metodo que relaciona la capa de control con el repositorio en la cual nos devolverá un listado de personas.
	 * @return listado de personas incluidas en la agenda
	 */
	public List<Persona> list();
	
	/**
	 * Metodo que relaciona la capa de control con el repositorio en la cual podemos introducir un contacto.
	 * @param persona Introducimos al método el contacto que queremos agregar.
	 */
	public void add(Persona persona);
	
}
