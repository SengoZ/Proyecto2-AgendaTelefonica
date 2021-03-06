/**
 * 
 */
package com.spring.proyecto2.services;

import java.util.List;

import com.spring.proyecto2.model.Direccion;
import com.spring.proyecto2.model.Persona;
import com.spring.proyecto2.model.Provincia;
import com.spring.proyecto2.model.Telefono;

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
	 * @return listado Listado de personas incluidas en la agenda
	 */
	public List<Persona> list();
	
	/**
	 * Metodo que relaciona la capa de control con el repositorio en la cual nos devolverá un listado de provincias.
	 * @return listado Listado de provincias incluidas en la tabla provincias
	 */
	public List<Provincia> listProv();
	
	/**
	 * Metodo que relaciona la capa de control con el repositorio en la cual podemos introducir un contacto.
	 * @param pers	parámetro con los datos de la persona
	 * @param dir	parámetro con los datos de la dirección de la persona.
	 * @param tel	parámetro con los datos del telefono de la persona.
	 * @param prov	parámetro copntiene la provincia donde está la persona.
	 */
	public void add(Persona pers, Direccion dir, Telefono tel, Provincia prov);
	
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
	
	/**
	 * Metodo que relaciona la cpa de control con el repositorio, en la cual editamos un contacto de la agenda a partir de un id como parámetro de entrada
	 * @param pers	parámetro con los datos de la persona
	 * @param dir	parámetro con los datos de la dirección de la persona.
	 * @param tel	parámetro con los datos del telefono de la persona.
	 * @param prov	parámetro copntiene la provincia donde está la persona.
	 */
	public void edit(Persona pers, Direccion dir, Telefono tel, Provincia prov);
}
