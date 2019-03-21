/**
 * 
 */
package com.spring.proyecto2.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.proyecto2.model.Persona;

/**
 * @author Sheila Garcia, Cesar Marcos, Amador Caceres, Andres Gomez
 * @version 1.0
 * 
 * Interfaz de datos de la aplicación de Agenda telefónica
 *
 */
public interface AgendaDao extends JpaRepository<Persona, Long> {

}
