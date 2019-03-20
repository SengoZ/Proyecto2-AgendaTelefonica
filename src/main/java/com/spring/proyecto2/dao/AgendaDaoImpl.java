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
 *
 */
//Se utiliza la anotación repository indicando que es un DAO 
@Repository
public class AgendaDaoImpl implements AgendaDao{
	
	//Se define la unidad de persistencia.
	@PersistenceContext	
	private EntityManager entityManager;
	
	//Se crea el constructor vacio.
	
	public AgendaDaoImpl() {
		super();
	}

	//Se creal el método list, en el que se da de alta a las personas.
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Persona> list() {
		String hql = "FROM Persona ORDER BY ID";
		return (List<Persona>) entityManager.createQuery(hql).getResultList();
		
		
	}

	@Override
	public void add(Persona persona) {
		entityManager.merge(persona);
		
	}

	@Override
	public Persona buscarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Persona fichaContacto(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
