package ej3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class PruebasGestionComercial extends TestCase{
	private ArrayList<Comercial> lc;
	private TelefonoMovil t;
	private Comercial c,nulo;
	@Before
	public void setUp(){
		lc = new ArrayList<Comercial>();
		t = new TelefonoMovil("666777888", 10);
		c = new Comercial("Ikk1", 555, t);
		nulo = null;
	}
	
	@Test
	public void testGuardarComercialesCreaFichero() throws FileNotFoundException, IOException{
		lc.add(c);
		lc.add(nulo);
		
		File f = new File("comerciales.data");
		GestionComercial gc = new GestionComercial("comerciales.data");
		gc.guardaComerciales(lc);
		
		assertTrue(f.exists());
	}
	
	@Test
	public void testGuardarComercialesCreaFicheroDistinto() throws FileNotFoundException, IOException{
		lc.add(c);
		lc.add(nulo);
		
		File f = new File("comerciales2.data");
		GestionComercial gc = new GestionComercial("comerciales2.data");
		gc.guardaComerciales(lc);
		
		assertTrue(f.exists());
	}
}
