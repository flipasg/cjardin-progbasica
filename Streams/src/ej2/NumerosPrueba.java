package ej2;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.ws.Action;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class NumerosPrueba extends TestCase{
	
	private Numeros n;
	private File f;
	
	@Before
	protected void setUp(){
		n = new Numeros();
		f = new File("numeros.bin"); 
	}
	
	@After
	public void tearDown(){
		f.delete();
	}
	
	@Test
	public void testGenerarUnNumeroEntreLimites(){
		assertTrue(n.generarUnNumero(0,2)<=2);
		assertTrue(n.generarUnNumero(0,2)>=0);
	}
	
	@Test
	public void testGenerarUnNumeroEntreLimitesDistintos(){
		assertTrue(n.generarUnNumero(40,100)<=100);
		assertTrue(n.generarUnNumero(40,100)>=40);
	}
	
	@Test
	public void testGenerarUnNumeroFueraDeLimites(){
		assertFalse(n.generarUnNumero(0,200)>200);
		assertFalse(n.generarUnNumero(0,200)<0);
	}
	
	@Test
	public void testGenerarListaNumerosLongitudCorrecta(){
		assertEquals(2, n.generarNumeros(0,2,2).size());
	}
	
	@Test
	public void testGenerarListaNumerosOtraLongitud(){
		assertEquals(3, n.generarNumeros(0,2,3).size());
	}
	
	@Test
	public void testAnadirUnNumeroCreaFichero() throws IOException{
		n.anadirUnNumero("numeros.bin", 2);
		
		
		assertTrue(f.exists());
	}
	
	@Test
	public void testAnadirUnNumeroLongitudFichero() throws IOException{
		long longitud = 0;
		
		if(f.exists()){
			longitud = f.length();
		}
		
		n.anadirUnNumero(f.getName(), 2);
		
		assertEquals((longitud+4), f.length());
	}
	
	@Test
	public void testAnadirNumerosEnFichero() throws IOException{
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		numeros.add(new Integer(4));
		numeros.add(new Integer(3));
		numeros.add(new Integer(6));
		numeros.add(new Integer(7));
		
		long longitud = 0;
		
		if(f.exists()){
			longitud = f.length();
		}
		n.anadirNumeros(f.getName(), numeros);
		
		assertEquals(longitud+(numeros.size()*4), f.length());
		
	}
	
	@Test
	public void testBuscarNumeroEnFichero() throws IOException{
		n.anadirUnNumero(f.getName(), 2);
		
		assertEquals(2, n.buscarEnFichero(f.getName(), 0));
		
		
	}
	
	/*@Test
	public void testBuscarNumeroEnFicheroPosicionDistinta() throws IOException{
		n.anadirUnNumero(f.getName(), 2);
		n.anadirUnNumero(f.getName(), 3);
		n.anadirUnNumero(f.getName(), 4);
		
		assertEquals(4, n.buscarEnFichero(f.getName(), 3));
		
		
	}*/
}

