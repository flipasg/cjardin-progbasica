/**
 *
 */
package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Iker Garcia Ramirez
 * @date 25/5/2015
 *
 */
public class Alumno {
    private String dni;
    private String nombre;
    private String poblacion;
    private String telefono;
    private java.util.Date fechaNacimiento;
    private int codCiclo;

    /**
     * Constructor de la clase Alumno
     *
     * @param dni
     * @param nombre
     * @param poblacion
     * @param telefono
     * @param fechaNacimiento
     * @param codCiclo
     */
    public Alumno(String dni, String nombre, String poblacion, String telefono,
	    java.util.Date fechaNacimiento, int codCiclo) {
	this.dni = dni;
	this.nombre = nombre;
	this.poblacion = poblacion;
	this.telefono = telefono;
	this.fechaNacimiento = fechaNacimiento;
	this.codCiclo = codCiclo;
    }

    /**
     * Constructor de la clase Alumno
     *
     * @throws IOException
     * @throws ParseException
     */
    public Alumno() throws IOException, ParseException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Dime el DNI: ");
	dni = br.readLine();
	System.out.println("Dime el nombre: ");
	nombre = br.readLine();
	System.out.println("Dime la poblacion: ");
	poblacion = br.readLine();
	System.out.println("Dime el telefono: ");
	telefono = br.readLine();
	System.out.println("Dime la fecha: ");
	String fecha = br.readLine();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	fechaNacimiento = sdf.parse(fecha);
	System.out.println("Dime el ciclo: ");
	codCiclo = Integer.parseInt(br.readLine());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Alumno: " + dni + "\n\t Nombre: " + nombre + "\n\t Poblacion: "
		+ poblacion + "\n\t Telefono: " + telefono
		+ "\n\t Fecha de nacimiento: " + fechaNacimiento
		+ "\n\t Ciclo: " + codCiclo;
    }

    /**
     * @return the dni
     */
    public String getDni() {
	return dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
	return nombre;
    }

    /**
     * @return the poblacion
     */
    public String getPoblacion() {
	return poblacion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
	return telefono;
    }

    /**
     * @return the fechaNacimiento
     */
    public java.util.Date getFechaNacimiento() {
	return fechaNacimiento;
    }

    /**
     * @return the codCiclo
     */
    public int getCodCiclo() {
	return codCiclo;
    }

}
