package com.spring.proyecto2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.proyecto2.dao.AgendaDao;
import com.spring.proyecto2.dao.AgendaProvincias;
import com.spring.proyecto2.model.Direccion;
import com.spring.proyecto2.model.Persona;
import com.spring.proyecto2.model.Provincia;
import com.spring.proyecto2.model.Telefono;

/**
 * @author Sheila Garcia, Cesar Marcos, Amador Caceres, Andres Gomez
 * @version 1.0
 * 
 *          Implementación de servicios de la aplicación de Agenda telefónica
 *          mediante la interfaz AgendaService
 *
 */

@Service
public class AgendaServiceImpl implements AgendaService {

	@Autowired
	private AgendaDao repository;

	@Autowired
	private AgendaProvincias provincias;

	/**
	 * {@inheritDoc}
	 * 
	 * Implementación del método en el cual nos devolverá un listado de personas.
	 * 
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
	 * 
	 * @param persona Introducimos al método el contacto que queremos agregar.
	 */
	@Override
	public void add(Persona persona) {
		repository.save(persona);
	}

	/**
	 * * {@inheritDoc}
	 * 
	 * Metodo en el cual nos devolverá el contacto de la agenda a partir de un id
	 * como parámetro
	 * 
	 * @param id Introducimos el identificador del usuario para poder obtener al
	 *           contacto buscado
	 * @return Persona Nos devolverá una persona en caso de encontrarla, si no lo
	 *         puede hacer nos devolverá un elemento nulo.
	 */
	@Override
	public Persona buscarId(int id) {
		return repository.findById(id).orElse(null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Método en el cual podemos eliminar un contacto de la agenda a partir de un id
	 * como parámetro.
	 * 
	 * @param id Introducimos el identificador del usuario para buscar el contacto a
	 *           eliminar
	 */
	@Override
	public void delete(int id) {
		Persona user = buscarId(id);
		if (user != null) {
			repository.delete(user);
		}
	}

	/**
	 * Metodo por el cual editamos un contacto de la agenda, a paritr de un id
	 * 
	 * @param id: Id identificador del contacto a editar
	 */
	@Override
	public void edit(Persona pers, Direccion dir, Telefono tel, Provincia prov) {
		repository.save(pers);
		for (Persona p : repository.findAll()) {
			if (pers.getDni().equalsIgnoreCase(p.getDni())) {
				dir.setPersona(p);
				dir.setProvincia(prov);
				tel.setPersona(p);
				System.out.println(dir.toString());
				List<Direccion> direcciones = new ArrayList<Direccion>();
				direcciones.add(dir);
				p.setDireccions(direcciones);
				List<Telefono> telefonos = new ArrayList<Telefono>();
				telefonos.add(tel);
				p.setTelefonos(telefonos);
				repository.save(p);
			}
		}
		/*
		 * dir.setPersona(p);
				tel.setPersona(p);
				

				
				repository.save(p);
		 */
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Implementación del método en el cual nos devolverá un listado de provincias.
	 * 
	 * @return List<Provincia> listado de provincias incluidas en la tabla provincia
	 */
	@Override
	public List<Provincia> listProv() {
		// TODO Auto-generated method stub
		return provincias.findAll();
	}
}
