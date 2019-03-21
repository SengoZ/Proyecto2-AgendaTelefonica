package com.spring.proyecto2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.proyecto2.dao.AgendaDao;
import com.spring.proyecto2.model.Persona;

/**
 * @author Sheila Garcia, Cesar Marcos, Amador Caceres, Andres Gomez
 * @version 1.0
 * 
 * Implementación de servicios de la aplicación de Agenda telefónica mediante la interfaz AgendaService
 *
 */

@Service
public class AgendaServiceImpl implements AgendaService{

	@Autowired
	private AgendaDao repository;
	

	/**
	 * {@inheritDoc}
	 * 
	 * Implementación del método en el cual nos devolverá un listado de personas.
	 * @return List<Persona> listado de personas incluidas en la agenda
	 */
	@Override
	public List<Persona> list() {
		return repository.findAll();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Método en el cual podemos introducir un contacto.
	 * @param persona Introducimos al método el contacto que queremos agregar.
	*/
	@Override
	public void add(Persona persona) {
		repository.save(persona);
	}
	
	/**
	 * * {@inheritDoc}
	 * 
	 * Metodo en el cual nos devolverá el contacto de la agenda a partir de un id como parámetro
	 * @param id Introducimos el identificador del usuario para poder obtener al contacto 
	 * buscado
	 * @return Persona Nos devolverá una persona en caso de encontrarla, si no lo puede hacer 
	 * nos devolverá un elemento nulo.
	 */
	@Override
	public Persona buscarId(int id) {
		return repository.findById( id).orElse(null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Método en el cual podemos eliminar un contacto de la agenda a partir de un id como parámetro.
	 * @param id Introducimos el identificador del usuario para buscar el contacto a eliminar
	 */
	@Override
	public void delete(int id) {
		Persona user = buscarId(id);
		if (user != null) {
			repository.delete(user);
		}
	}

}
