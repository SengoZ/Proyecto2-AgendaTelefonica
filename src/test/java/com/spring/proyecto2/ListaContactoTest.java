package com.spring.proyecto2;


import com.spring.proyecto2.model.Persona;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;

/**
 * 
 * @author Sheila Garcia
 *
 */

public class ListaContactoTest extends TestCase{
	
	
	@Test
	public void testCrearObjeto() {
		Persona persona = new Persona();
		assertNotNull(persona);
	}
	
	@Test
	public void testCrearLista() {
		List<Persona> lista = new ArrayList<Persona>();
		assertNotNull(lista);
	}
	
}