/**
 * 
 */
package com.spring.proyecto2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.proyecto2.model.Provincia;

/**
 * @author Sheila Garcia, Cesar Marcos, Amador Caceres, Andres Gomez
 * @version 1.0
 * 
 * Interfaz de datos de las provincias disponibles en la BBDD de la aplicación de Agenda telefónica
 *
 */
public interface AgendaProvincias extends JpaRepository<Provincia, Integer>{}
