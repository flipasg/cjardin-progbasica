package pack2;

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

		
		GestorActuaciones ga = new GestorActuaciones("actuaciones2.txt");
		ga.grabarFicheroPeliculas(); //si se añade la pelicula Mad City se comprueban casi todos los metodos
		String nombres[] = {"Igor","Pincho"};
		
		//comprobamos que la pelicula se añade y los actores al reparto y al fichero
		ga.nuevaPelicula(p1, nombres);
		
		//Visualizamos el contenido del fichero peliculas2.obj
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("peliculas2.obj"));
		Pelicula p;
		while ((p = (Pelicula) ois.readObject()) != null) System.out.println(p);
		ois.close();
		System.out.println();
		
		//creamos el mapaActores y lo visualizamos
		ga.cargarMapaActores();
		ga.verMapa();
		
		System.out.println(ga.repartoDePelicula("Mad city"));
		
		ga.grabarDuracionesMedias("duraciones2.bin");
		ga.verFicheroDuracionesMedias("duraciones2.bin");
		
	}
}
