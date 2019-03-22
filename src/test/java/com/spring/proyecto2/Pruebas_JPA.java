package com.spring.proyecto2;


import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

import javax.transaction.Transactional;

import com.spring.proyecto2.dao.AgendaDao;
import com.spring.proyecto2.services.AgendaService;
import com.spring.proyecto2.services.AgendaServiceImpl;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Pruebas_JPA extends TestCase{

	@Autowired
	AgendaDao repository;
	
	@Autowired
	AgendaService services;
	
	@Test
	public void testInstanceOf() {
		assertThat(repository, instanceOf(AgendaDao.class));
		assertThat(services, instanceOf(AgendaServiceImpl.class));
    }
	
	@Test
    public void testCarExists() {
            try {
                Class.forName("Hola");
            } catch(ClassNotFoundException e) {
            	Assert.fail("Should create a class called 'Hola'.");
            }
     }
	
	@Test
	@Transactional
	public void testDeleteTable() {
		repository.deleteAll();
		assertTrue(repository.findAll().size() == 0);
	}
	
	@Test
	@Transactional
	public void testDeleteId() {
		int init = repository.findAll().size();
		if(repository.findById(2)!=null)
			repository.deleteById(2);
		assertTrue((init-1) == repository.findAll().size());
	}

}