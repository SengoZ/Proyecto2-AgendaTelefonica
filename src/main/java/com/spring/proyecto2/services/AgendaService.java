/**
 * 
 */
package com.spring.proyecto2.services;

import java.util.List;

import com.spring.proyecto2.model.Persona;

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
	
	/**
	 * Metodo que relaciona la capa de control con el repositorio en la cual nos devolverá el contacto de la agenda a partir de un id como parámetro
	 * @param id Introducimos el identificador del usuario para poder obtener al contacto 
	 * buscado
	 * @return persona Nos devolverá una persona en caso de encontrarla, si no lo puede hacer 
	 * nos devolverá un elemento nulo.
	 */
	public Persona buscarId(int id);
	
	/**
	 * Metodo que relaciona la capa de control con el repositorio en la cual podemos eliminar un contacto de la agenda a partir de un id como parámetro
	 * @param id Introducimos el identificador del usuario para buscar el contacto a eliminar
	 */
	public void delete(int id);
}
