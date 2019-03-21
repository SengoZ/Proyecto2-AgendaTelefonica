package com.spring.proyecto2.dao;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author Grupo 3: Amador Cáceres, Cesar Marcos, Andrés Gomez y Sheila García
 * @version 1.0
 * 
 * Implementación de la interfaz de DAO de la aplicación de Agenda telefónica (Repositorio)
 *
 */

@Repository
public class AgendaDaoImpl{
	
	private final AgendaDao repository;
	
	public AgendaDaoImpl(AgendaDao repository) {
	     this.repository = repository;
	 }
	
	
}
