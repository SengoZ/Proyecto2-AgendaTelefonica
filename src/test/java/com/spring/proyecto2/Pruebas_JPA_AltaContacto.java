package com.spring.proyecto2;



import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.junit4.SpringRunner;

import com.spring.proyecto2.dao.AgendaDao;
import com.spring.proyecto2.model.Persona;

import junit.framework.TestCase;

/**
 * 
 * @author Sheila
 *
 */
@RunWith(SpringRunner.class)
public class Pruebas_JPA_AltaContacto extends TestCase {

	
		@Autowired
		AgendaDao repository;

		@Test
		public void testAltaContacto() {
			repository.deleteAll();
			Persona persona = new Persona();
			repository.save(persona);
			assertEquals(1, repository.count());
		}
		
		
		

	}
