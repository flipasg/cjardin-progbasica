/**
 *
 */
package ej1acces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Iker Garcia Ramirez
 * @date 15/5/2015
 *
 */
public class PruebaCiclos {
    public static void main(String[] args) {
	String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	String conbase = "jdbc:odbc:";
	try {

	    String bbdd = "dsnciclos";
	    Class.forName(driver);
	    Connection conexion = DriverManager.getConnection(conbase + bbdd);

	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
