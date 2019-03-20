package com.spring.proyecto2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.proyecto2.model.Persona;

/**
 * 
 * @author Grupo 3: Amador Cáceres, Cesar Marcos, Andrés Gomez y Sheila García
 * @version 1.0
 * 
 * Implementación de la interfaz de DAO de la aplicación de Agenda telefónica (Repositorio)
 *
 */

@Repository
public class AgendaDaoImpl implements AgendaDao{
	
	/**
	 * Definición de la unidad de persistencia y constructor vacío
	 */
	@PersistenceContext	
	private EntityManager entityManager;
	
	public AgendaDaoImpl() {
		super();
	}

	/**
	 * Método que devuelve el listado de todos los contactos que hay en la agenda
	 * @return listado de personas incluidas en la agenda
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Persona> list() {
		String hql = "FROM Persona ORDER BY ID";
		return (List<Persona>) entityManager.createQuery(hql).getResultList();
	}

	/**
	 * /**
	 * Método que nos permite introducir a un nuevo contacto
	 * @param persona Introducimos al método el contacto que queremos agregar.
	 */
	@Override
	public void add(Persona persona) {
		entityManager.merge(persona);
		
	}

	/**
	 * /**
	 * Método que devuelve el contacto de la agenda a partir de un id como parámetro
	 * @param id Introducimos el identificador del usuario para poder obtener al contacto 
	 * buscado
	 * @return persona Nos devolverá una persona en caso de encontrarla, si no lo puede hacer 
	 * nos devolverá un elemento nulo.
	 *
	 */
	@Override
	public Persona buscarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Método para eliminar un contacto de la agenda a partir de un id como parámetro
	 * @param id Introducimos el identificador del usuario para buscar el contacto a eliminar
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Método para devolver la ficha de una persona concreta a partir de su identificador
	 * @param id Pasamos por parametro el identificador concreto.
	 * @return devolvemos la ficha del contacto deseado.
	 */
	@Override
	public Persona fichaContacto(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
