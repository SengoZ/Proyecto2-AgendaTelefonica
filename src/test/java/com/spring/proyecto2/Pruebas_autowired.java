package com.spring.proyecto2;


import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

import com.spring.proyecto2.dao.AgendaDao;
import com.spring.proyecto2.services.AgendaService;
import com.spring.proyecto2.services.AgendaServiceImpl;

import junit.framework.TestCase;


/**
 * 
 * @author Andrés
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Pruebas_autowired extends TestCase{

	@Autowired
	AgendaDao repository;
	
	@Autowired
	AgendaService services;
	
	@Test
	public void testInstanceOf() {
		assertThat(repository, instanceOf(AgendaDao.class));
		assertThat(services, instanceOf(AgendaServiceImpl.class));
    }

}