package ej3;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PruebasComercial extends TestCase{
	private Comercial c;
	
	@Mock
	private TelefonoMovil t;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		c = new Comercial("Ikk", 555, t);
	}
	
	@Test
	public void testGetSetSalario(){
		c.setSalario(2000);
		assertEquals(2000, c.getSalario());
	}
	
	@Test
	public void testTrabajarSinParametrosIncrementaSalario(){
		int salario = c.getSalario();
		c.trabajar();
		
		assertEquals((salario+10), c.getSalario());
	}
	
	@Test
	public void testTrabajarSinParametrosLlamaALlamar(){
		c.trabajar();
		
		Mockito.verify(t).llamar(15);
	}
	
	@Test
	public void testTrabajarConParametrosIncrementaSalario(){
		int salario = c.getSalario();
		c.trabajar(30, 45);
		
		assertEquals((salario+30), c.getSalario());
	}
	
	@Test
	public void testTrabajarConParametrosLlamaALlamar(){
		c.trabajar();
		
		Mockito.verify(t).llamar(Mockito.anyInt());
	}
}
