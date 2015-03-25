package ejer5;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Comercial other = (Comercial) obj;
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the salario
	 */
	public int getSalario() {
		return salario;
	}

	/**
	 * @return the t
	 */
	public TelefonoMovil getT() {
		return t;
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
