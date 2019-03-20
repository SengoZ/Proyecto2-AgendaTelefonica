/**
 * 
 */
package com.spring.proyecto2.dao;

import java.util.List;

import com.spring.proyecto2.model.Persona;

/**
 * @author Sheila Garcia, Cesar Marcos, Amador Caceres, Andres Gomez
 * @version 1.0
 * 
 * Interfaz de DAO de la aplicación de Agenda telefónica
 *
 */
public interface AgendaDao {
	
	/**
	 * Método que devuelve el listado de todos los contactos que hay en la agenda
	 * @return listado de personas incluidas en la agenda
	 */
	public List<Persona> list();
	
	/**
	 * Método que nos permite introducir a un nuevo contacto
	 * @param persona Introducimos al método el contacto que queremos agregar.
	 */
	public void add(Persona persona);
	

}
