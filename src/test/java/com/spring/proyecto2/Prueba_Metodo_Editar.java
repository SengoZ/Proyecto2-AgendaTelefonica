package com.spring.proyecto2;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.proyecto2.dao.AgendaDao;
import com.spring.proyecto2.model.Contacto;
import com.spring.proyecto2.model.Direccion;
import com.spring.proyecto2.model.Persona;
import com.spring.proyecto2.model.Provincia;
import com.spring.proyecto2.model.Telefono;
import com.spring.proyecto2.services.AgendaService;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Prueba_Metodo_Editar extends TestCase {

	@Autowired
	AgendaService services;
	
	@Autowired
	AgendaDao repository;
	
	@Test
	public void inicializar_Persona() {
		
	}
	
	@Test
	public void inicializar_Direccion() {
		
	}
	
	@Test
	public void inicializar_Telefono() {
		
	}
	
	/**
	 * Falla prueba unitaria
	 */
	@Test
	public void prueba_Editar() {
		Persona p = services.buscarId(3);
		String antiguo = p.getNombre();
		p.setNombre("Ramón");
		System.out.println("************************");
		services.add(p, p.getDireccions().get(0), p.getTelefonos().get(0), p.getDireccions().get(0).getProvincia());
		//repository.save(p);
		System.out.println("*****************************************************************");
		String nuevo = services.buscarId(3).getNombre();
		assertEquals(antiguo, nuevo);
	}
}
