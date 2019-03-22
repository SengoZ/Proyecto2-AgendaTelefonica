package com.spring.proyecto2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.proyecto2.dao.AgendaDao;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Pruebas_JPA_BorrarContacto extends TestCase{
	
	@Autowired
	AgendaDao repository;
	
	@Test
	public void testBorrarContacto() {
		int cantidad = (int) repository.count();
		int pos =1;
		repository.deleteById(pos);
		if(repository.findById(pos) == null) {
			assertEquals(cantidad, repository.count());
		}
		else {
			assertEquals((cantidad-1), repository.count());
		}
	}
}
