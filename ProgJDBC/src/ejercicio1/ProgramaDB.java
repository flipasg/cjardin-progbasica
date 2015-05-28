/**
 *
 */
package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Iker Garcia Ramirez
 * @date 25/5/2015
 *
 */
public class ProgramaDB {

    /**
     * @param args
     */
    public static void main(String[] args) {

	try {
	    GestorAlumnos ga = new GestorAlumnos();
	    System.out.println(ga.crearTablas());
	    BufferedReader bf = new BufferedReader(new InputStreamReader(
		    System.in));
	    int r = -1;
	    do {
		System.out.println("Dime una operacion a realizar: \n"
			+ "1-Listar Alumnos\n" + "2-Buscar Alumno\n"
			+ "3-Eliminar Alumno\n" + "4-Insertar Alumno\n"
			+ "5-Modificar Alumno\n" + "0-Salir\n");
		r = Integer.parseInt(bf.readLine());
		if (r == 1) {
		    ArrayList<Alumno> listaAlumnos = ga.listadoAlumnos();
		    for (Alumno a : listaAlumnos) {
			System.out.println(a);
		    }
		}
		if ((r == 2) || (r == 3) || (r == 5)) {
		    System.out.println("Dime el dni del alumno");
		    String dni = bf.readLine();

		    if (r == 2) {
			System.out.println(ga.buscaAlumno(dni));
		    } else if (r == 3) {
			ga.eliminarAlumno(dni);
		    } else {
			System.out.println("Introduce los datos del alumno");
			ga.modificarAlumno(dni, new Alumno());
		    }

		}
		if (r == 4) {
		    ga.insertarAlumno(new Alumno());
		}

	    } while (r != 0);

	    Ciclo[] ciclos = ga.todosCiclos();
	    System.out.println(Arrays.toString(ciclos));

	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (SQLException e) {
	    e.printStackTrace();
	} catch (NumberFormatException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (ParseException e) {
	    e.printStackTrace();
	}

    }

}
