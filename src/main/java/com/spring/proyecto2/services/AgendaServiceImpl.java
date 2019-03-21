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
	 * add whatever you would like here
	 */
	@Override
	public List<Persona> list() {
		return repository.findAll();
	}

	@Override
	public void add(Persona persona) {
		repository.save(persona);
	}
	
	@Override
	public Persona buscarId(int id) {
		return repository.findById((long) id).orElse(null);
	}

	@Override
	public void delete(int id) {
		Persona user = buscarId(id);
		if (user != null) {
			repository.delete(user);
		}
	}

}
