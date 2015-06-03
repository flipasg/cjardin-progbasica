package pack1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Principal {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Pelicula p1 = new Pelicula("Mad city", 1998, 114);
		Pelicula p2 = new Pelicula("El fugitivo", 1991, 130);
		Pelicula p3 = new Pelicula("Rainman", 1988, 133);
		Pelicula p4 = new Pelicula("Candilejas", 1952, 134);
		Pelicula p5 = new Pelicula("Hook", 1991, 132);
		Pelicula p6 = new Pelicula("Witness", 1988, 112);
		
		//creamos un array de peliculas para probar el metodo grabarFicheroActuaciones
		Pelicula aPeliculas[] = new Pelicula[7];
		aPeliculas[0] = p1;
		aPeliculas[1] = p2;
		aPeliculas[2] = p3;
		aPeliculas[3] = p4;
		aPeliculas[4] = p5;
		aPeliculas[5] = p6;
		aPeliculas[6] = null;
		
		GestorActuaciones ga = new GestorActuaciones("actuaciones.txt");
		ga.grabarFicheroPeliculas(aPeliculas);
		
		
		//Visualizamos el contenido del fichero peliculas.obj
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("peliculas.obj"));
		Pelicula p;
		while ((p = (Pelicula) ois.readObject()) != null) System.out.println(p);
		ois.close();
		System.out.println();
		
		//creamos el mapaActores y lo visualizamos
		ga.cargarMapaActores();
		ga.verMapa();
		
		System.out.println(ga.repartoDePelicula("Mad city"));
		System.out.println();
		
		System.out.println(ga.repartoDePelicula("Mcdy"));
		System.out.println();
		
		ga.grabarDuracionesMedias("duraciones.bin");
		ga.verFicheroDuracionesMedias("duraciones.bin");
		
	}
}
