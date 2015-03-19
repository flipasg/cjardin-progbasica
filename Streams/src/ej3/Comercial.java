package ej3;

import java.io.Serializable;

public class Comercial implements Serializable{
	private String nombre;
	private int salario;
	private TelefonoMovil t;
	
	/**
	 * @param nombre
	 * @param salario
	 * @param t
	 */
	public Comercial(String nombre, int salario, TelefonoMovil t) {
		this.nombre = nombre;
		this.salario = salario;
		this.t = t;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Nombre: " + nombre + "con un salario de" + salario + " y " + t.toString();
	}
	
	/**
	 * @return the salario
	 */
	public int getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(int salario) {
		this.salario = salario;
	}

	public void trabajar(){
		salario+=10;
		t.llamar(15);
	}
	
	/**
	 * @param incremento
	 * @param minutos
	 */
	public void trabajar(int incremento, int minutos){
		salario+=incremento;
		t.llamar(minutos);
	}
}
