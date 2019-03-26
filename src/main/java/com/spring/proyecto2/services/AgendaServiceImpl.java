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
	 * @return List(personas) listado de personas incluidas en la agenda
	 */
	@Override
	public List<Persona> list() {
		return repository.findAll();
	}

	/**
	 * Método en el que podemos introducir un nuevo contacto.
	 * 
	 * @param pers parámetro con los datos de la persona
	 * @param dir  parámetro con los datos de la dirección de la persona.
	 * @param tel  parámetro con los datos del telefono de la persona.
	 * @param prov parámetro copntiene la provincia donde está la persona.
	 */
	@Override
	public void add(Persona pers, Direccion dir, Telefono tel, Provincia prov) {
		dir.setPersona(pers);
		dir.setProvincia(prov);
		tel.setPersona(pers);
		List<Direccion> direcciones = new ArrayList<Direccion>();
		direcciones.add(dir);
		pers.setDireccions(direcciones);
		List<Telefono> telefonos = new ArrayList<Telefono>();
		telefonos.add(tel);
		pers.setTelefonos(telefonos);
		repository.save(pers);
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
	 * Metodo en el que editamos un contacto de la agenda, a paritr de un id
	 * 
	 * @param pers parámetro con los datos de la persona
	 * @param dir  parámetro con los datos de la dirección de la persona.
	 * @param tel  parámetro con los datos del telefono de la persona.
	 * @param prov parámetro copntiene la provincia donde está la persona.
	 */
	@Override
	public void edit(Persona pers, Direccion dir, Telefono tel, Provincia prov) {
		dir.setPersona(pers);
		dir.setIddireccion(buscarId(pers.getIdpersona()).getDireccions().get(0).getIddireccion());
		dir.setProvincia(prov);
		tel.setPersona(pers);
		tel.setIdtelefono(buscarId(pers.getIdpersona()).getTelefonos().get(0).getIdtelefono());
		List<Direccion> direcciones = new ArrayList<Direccion>();
		direcciones.add(dir);
		pers.setDireccions(direcciones);
		List<Telefono> telefonos = new ArrayList<Telefono>();
		telefonos.add(tel);
		pers.setTelefonos(telefonos);
		repository.save(pers);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * Implementación del método en el cual nos devolverá un listado de provincias.
	 * 
	 * @return List(Provincias) listado de provincias incluidas en la tabla
	 *         provincia
	 */
	@Override
	public List<Provincia> listProv() {
		return provincias.findAll();
	}
}
