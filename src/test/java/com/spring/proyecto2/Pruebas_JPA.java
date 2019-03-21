package com.spring.proyecto2;



import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.proyecto2.dao.AgendaDao;

import junit.framework.TestCase;


@RunWith(SpringRunner.class)
public class Pruebas_JPA extends TestCase{
	@Autowired
	AgendaDao repository;

	@Test
	@Transactional
	public void testDeleteTable() {
		repository.deleteAll();
		assertTrue(repository.findAll().size() == 0);
	}

}