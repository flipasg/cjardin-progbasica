package ejer5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Principal {
	
	public static void grabarComerciales(File f) throws IOException{
		String respuesta = "";
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
		do {
			Comercial c = null;
			String nombre = "";
			int salario = 0;
			TelefonoMovil t = null;
			String numero = "";
			int saldo = 0;
			
			try {
				System.out.println("Dime el nombre del comercial");
				nombre = buffReader.readLine();
				System.out.println("Dime el salario");
				salario = Integer.parseInt(buffReader.readLine());
				System.out.println("Dime el número de telefono");
				numero = buffReader.readLine();
				System.out.println("Dime el saldo del telefono");
				saldo = Integer.parseInt(buffReader.readLine());
				t = new TelefonoMovil(numero, saldo);
				c = new Comercial(nombre, salario, t);
				try {
					if(evaluarComercial(c)){
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
						oos.writeObject(c);
						oos.close();
					}
				} catch (ErrorComercialException e) {
					System.err.println("Comercial no válido");
				} 
			} catch (IOException e) {
				System.err.println("Error de entrada/salida");
			}
			
		} while (!respuesta.toLowerCase().startsWith("s"));
		
		buffReader.close();
	}
	
	private static boolean evaluarComercial(Comercial c) throws ErrorComercialException{
		int salario = c.getSalario();
		TelefonoMovil t = c.getT();
		if(salario<0 || t==null || !t.getNumero().matches("\\d{9}")) throw new ErrorComercialException("Error comercial no válido");
		return true;
	}
	
	public static HashMap<String, TelefonoMovil> generarMapaMoviles(ArrayList<Comercial> listaComerciales){
		HashMap<String, TelefonoMovil> mapaMoviles = new HashMap<String, TelefonoMovil>();
		for (Comercial c : listaComerciales) {
			mapaMoviles.put(c.getNombre(), c.getT());
		}
		
		return mapaMoviles;
	}
	
	public static void buscaMovil(HashMap<String, TelefonoMovil> mapaMoviles) throws Exception{
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in)); //tu habrás usado la clase consola
		System.out.println("Dime un nombre de Comercial");
		String nombreComercial = buffReader.readLine();
		if(mapaMoviles.containsKey(nombreComercial)) System.out.println(mapaMoviles.get(nombreComercial));
		else throw new Exception();
		buffReader.close();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader buffReader = null;
		String nombreFichero;
		try {
			buffReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Dime el nombre del archivo");
			nombreFichero = buffReader.readLine();
			File ficheroComerciales = new File(nombreFichero);
			if(ficheroComerciales.exists()) grabarComerciales(ficheroComerciales);
			
			ArrayList<Comercial> listaComerciales = new ArrayList<Comercial>();
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroComerciales));
			Comercial c;
			try {
				do {
					c = (Comercial) ois.readObject();
					if(!listaComerciales.contains(c)) listaComerciales.add(c);
				} while (c!=null);
					
			} catch (ClassNotFoundException e) {
				System.err.println("Clase no encontrada");
			}
			ois.close();
			
			HashMap<String, TelefonoMovil> mapaMoviles = generarMapaMoviles(listaComerciales);
			
			try {
				buscaMovil(mapaMoviles);
			} catch (Exception e) {
				System.err.println("Comercial no existente");
			}
			
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
		} finally {
			if(buffReader!=null) buffReader.close();
		}
		
		
	}
}
