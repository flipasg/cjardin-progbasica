package pack2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GestorActuaciones {
	private static final int ANIO_INI = 1000;
	private static final int ANIO_FIN = 2000;
	private static final String FICHEROPELICULAS = "peliculas2.obj";
	private String ficheroActuaciones;
	private HashMap<String, ArrayList<Pelicula>> mapaActores;
	
	public GestorActuaciones(String ficheroActuaciones) {
		this.ficheroActuaciones = ficheroActuaciones;
		mapaActores = new HashMap<String, ArrayList<Pelicula>>(); //inicializamos vacio
	}
	
	public void grabarFicheroPeliculas() {
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FICHEROPELICULAS));
			String respuesta = "";
			do {
				peliculas.add(pedirPelicula());
				System.out.println("¿Desea seguir anadiendo peliculas?");
				respuesta = Consola.leeString();
			} while (respuesta.toLowerCase().startsWith("s"));
			peliculas.add(null);
			
			for (Iterator it = peliculas.iterator(); it.hasNext();) {
				Pelicula p = (Pelicula) it.next();
				oos.writeObject(p);
			}
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
			e.printStackTrace();
		} catch (PeliculaException e) {
			System.err.println("Error de Pelicula");
			e.printStackTrace();
		} finally {
			if(oos!=null){
				try {
					oos.writeObject(null);
					oos.close();
				} catch (IOException e) {
					System.err.println("Error de entrada salida");
					e.printStackTrace();
				}
			}
				
		}
		
	}
	
	private Pelicula pedirPelicula() throws PeliculaException {
		String titulo = "";
		int anio = 0;
		int duracion = 0;
		try {
			System.out.println("Dime el tiulo de la pelicula");
			titulo = Consola.leeString();
			System.out.println("Dime el anio de la pelicula");
			anio = Consola.leeInt();
			if(anio>ANIO_FIN || anio<ANIO_INI) throw new PeliculaException("El año está fuera de los permitidos");
			System.out.println("Dime la duracion de la pelicula");
			duracion = Consola.leeInt();
			if(duracion<0) throw new PeliculaException("La duración no puede ser negativa");
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");;
		}
		
		return new Pelicula(titulo, anio, duracion);
			
	}
	
	public void cargarMapaActores() throws IOException, ClassNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(ficheroActuaciones));
		String linea;
		while ((linea = br.readLine()) != null) {
			String actor = linea.split("\t")[1];
			String tituloPelicula = linea.split("\t")[0];
			if(!mapaActores.containsKey(actor)) {
				mapaActores.put(actor, new ArrayList<Pelicula>());
			}
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHEROPELICULAS));
			Pelicula p;
			boolean encontrado = false;
			while (!encontrado && (p = (Pelicula) ois.readObject()) != null) {
				if (p.getTitulo().equalsIgnoreCase(tituloPelicula)) {
					mapaActores.get(actor).add(p);
					encontrado = true;
				}
			}
			ois.close();	
		}
		br.close();
	}
	
	public void verMapa() {
		for (Iterator it = mapaActores.keySet().iterator(); it.hasNext();) {
			String actor = (String) it.next();
			ArrayList<Pelicula> peliculas = mapaActores.get(actor);
			System.out.println(actor + " - " + peliculas.size() + " peliculas. ");
			for (Iterator itPeliculas = peliculas.iterator(); itPeliculas.hasNext();) {
				Pelicula p = (Pelicula) itPeliculas.next();
				System.out.println("\t > " + p);
			}
			
		}
	}
	
	public String repartoDePelicula(String titulo) {
		String reparto = "";
		for (Iterator it = mapaActores.keySet().iterator(); it.hasNext();) {
			String actor = (String) it.next();
			ArrayList<Pelicula> peliculas = mapaActores.get(actor);
			for (Iterator itPeliculas = peliculas.iterator(); itPeliculas.hasNext();) {
				Pelicula p = (Pelicula) itPeliculas.next();
				if(p.getTitulo().equalsIgnoreCase(titulo)) reparto+=actor + ", ";
			}
			
		}
		
		if(reparto.equals("")) return "No tenemos la pelicula en la BD";
		return reparto;
	}
	
	public void grabarDuracionesMedias(String fichero) throws IOException, ClassNotFoundException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(fichero));
		HashMap<Integer, Integer> anioMedia = hashDuraciones();
		for (Iterator it = anioMedia.keySet().iterator(); it.hasNext();) {
			Integer anio = (Integer) it.next();
			int a = anio.intValue();
			int d = anioMedia.get(anio).intValue();
			dos.writeInt(a);
			dos.writeInt(d);
		}
		dos.close();
	}
	
	public void verFicheroDuracionesMedias(String fichero) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(fichero));
			int disponible = dis.available()/(Integer.SIZE/8);
			for (int i = 0; i < disponible; i++) {
				if(i%2!=0) System.out.println("Duracion media " + dis.readInt() + " minutos");
				else System.out.println("Año " + dis.readInt());
				
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error de entrada salida");
			e.printStackTrace();
		} finally {
			if(dis!=null)
				try {
					dis.close();
				} catch (IOException e) {
					System.err.println("Error de entrada salida");
					e.printStackTrace();
				}
			
		}
	}
	
	private HashMap<Integer, Integer> hashDuraciones() throws ClassNotFoundException, IOException {
		ArrayList<Integer> anios = aniosDistintos();
		HashMap<Integer, Integer> anioMedia = new HashMap<Integer, Integer>();
		for (Iterator it = anios.iterator(); it.hasNext();) {
			Integer anio = (Integer) it.next();
			int cantidadPeliculas = peliculasEnAnio(anio.intValue());
			int sumaPeliculas = sumaPeliculasAnio(anio.intValue());
			if (!anioMedia.containsKey(anio.intValue())) anioMedia.put(anio, (sumaPeliculas/cantidadPeliculas));
		}
		return anioMedia;
	}
	
	private ArrayList<Integer> aniosDistintos() throws ClassNotFoundException, IOException {
		ArrayList<Integer> anios = new ArrayList<Integer>();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHEROPELICULAS));
		Pelicula p;
		while ((p = (Pelicula) ois.readObject()) != null) {
			if (!anios.contains(new Integer(p.getAnio()))) anios.add(new Integer(p.getAnio()));
		}
		ois.close();
		return anios;
	}
	
	private int sumaPeliculasAnio(int anio) throws FileNotFoundException, IOException, ClassNotFoundException {
		int suma = 0;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHEROPELICULAS));
		Pelicula p;
		while ((p = (Pelicula) ois.readObject()) != null) {
			if (p.getAnio()==anio) suma+=p.getDuracion();
		}
		ois.close();	
		return suma;
	}
	
	private int peliculasEnAnio(int anio) throws ClassNotFoundException, IOException {
		int numeroDepeliculas = 0;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHEROPELICULAS));
		Pelicula p;
		while ((p = (Pelicula) ois.readObject()) != null) {
			if (p.getAnio()==anio) numeroDepeliculas++;
		}
		ois.close();	
		return numeroDepeliculas;
	}
	
	public void nuevaPelicula(Pelicula p, String[] nombres) {
		String titulo = p.getTitulo();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(FICHEROPELICULAS));
			Pelicula pFichero;
			boolean encontrado = false;
			while (!encontrado && (pFichero = (Pelicula) ois.readObject()) != null) {
				if(pFichero.getTitulo().equals(titulo)) encontrado = true;
			}
			
			if(!encontrado) {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHEROPELICULAS, true));
				oos.writeObject(p);
				oos.close();
			}
			
			
			for (int i = 0; i < nombres.length; i++) {
				String lineaMetodo = titulo + "\t" + nombres[i];
				encontrado = false;
				BufferedReader br = new BufferedReader(new FileReader(ficheroActuaciones));
				String linea;
				while (!encontrado && (linea = br.readLine()) != null) {
					if(linea.equals(lineaMetodo)) encontrado = true;
				}
				
				if(!encontrado) {
					BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroActuaciones, true));
					bw.newLine();
					bw.write(lineaMetodo);
					bw.close();
				}
				br.close();
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Clase no encontrada");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
			e.printStackTrace();
		} finally {
			if(ois!=null)
				try {
					ois.close();
				} catch (IOException e) {
					System.err.println("Error de entrada/salida");
					e.printStackTrace();
				}
		}
		
	}
}
