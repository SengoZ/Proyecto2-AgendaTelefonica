/**
 * 
 */
package com.spring.proyecto2.dao;

import java.util.List;

/**
 * @author Andrés Gómez
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

}
