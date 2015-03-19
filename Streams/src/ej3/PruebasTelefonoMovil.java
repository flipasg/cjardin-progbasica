package ej3;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class PruebasTelefonoMovil extends TestCase{
	private TelefonoMovil t;
	
	@Before
	public void setUp(){
		t = new TelefonoMovil("666777888", 10);
	}
	
	@Test
	public void testGetSetSaldo(){
		t.setSaldo(20);
		assertEquals(20, t.getSaldo());
		
	}
	
	@Test
	public void testCargarSaldo(){
		t.cargar(20);
		assertEquals(30, t.getSaldo());
	}
	
	@Test
	public void testCargarSaldoNegativo(){
		t.cargar(-20);
		assertEquals(10, t.getSaldo());
	}
	
	@Test
	public void testLlamar(){
		t.llamar(5);
		assertEquals(0, t.getSaldo());
	}
	
	@Test
	public void testLlamarMinutosNegativos(){
		t.llamar(-5);
		assertEquals(10, t.getSaldo());
	}
	
	@Test
	public void testLlamarSaldoInsuficiente(){
		t.llamar(20);
		assertEquals(0, t.getSaldo());
	}
}
