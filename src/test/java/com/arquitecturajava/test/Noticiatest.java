package com.arquitecturajava.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.arquitecturajava.bo.Noticia;

public class Noticiatest 
{
	EntityManagerFactory emf;
	EntityManager em;
	
	
	@Before
	public void iniciar()
	{
		
		Persistence.generateSchema("curso",null);
		emf = Persistence.createEntityManagerFactory("curso");
	}

	@Test
	public void entityManagerFactoryOK() {
		
		assertNotNull(emf);
	}
	
	
	@Test
	public void EntityManagerOk()
	{
		
		assertNotNull(emf);
	}
	
	@Test
	public void seleccionarNoticiaInicial()
	{
		Noticia noticia = em.find(Noticia.class, "Java 8");
		assertEquals("nelson ortiz",noticia.getAutor());
		
	}
	
	@Test
	public void borrarNoticiaInicial() {
		
		Noticia noticia= em.find(Noticia.class, "Java 8");
		em.getTransaction().begin();
		em.remove(noticia);
		em.getTransaction().commit();
		Noticia sinNoticia= em.find(Noticia.class, "Java 8");
		assertNull(sinNoticia);
		
	}
	
	@Test
	public void insertarNuevaNoticia() {
		
		em.getTransaction().begin();
		Noticia noticiaNueva= new Noticia("java 8 y streams","Cecilio",new Date());
		em.persist(noticiaNueva);
		em.getTransaction().commit();
		Noticia noticiaInsertada= em.find(Noticia.class,"java 8 y streams");
		
		
	}
	
}
