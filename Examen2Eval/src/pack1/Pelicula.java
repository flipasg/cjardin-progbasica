package pack1;

import java.io.Serializable;

public class Pelicula implements Serializable{
	private String titulo;
	private int anio;
	private int duracion; //minutos
	
	public Pelicula(String titulo, int anio, int duracion) {
		this.titulo = titulo;
		this.anio = anio;
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		String str = titulo + ", " + anio + ", ";
		if(duracion >= 60) {
			int horas = 0;
			int minutos = 0;
			horas = duracion/60;
			minutos = duracion%60;
			str += horas + "h " + minutos;
		} else {
			str += duracion;
		}
		return str;
	}

	public int getDuracion() {
		return duracion;
	}

	public int getAnio() {
		return anio;
	}

	public String getTitulo() {
		return titulo;
	}
	
	
}
