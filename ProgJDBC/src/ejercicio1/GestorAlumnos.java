/**
 *
 */
package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Iker Garcia Ramirez
 * @date 25/5/2015
 *
 */
public class GestorAlumnos {
    private Connection connection;
    private PreparedStatement insertStatment;

    /**
     * Constructor de la clase GestorAlumnos
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public GestorAlumnos() throws ClassNotFoundException, SQLException {
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String CONBASE = "jdbc:mysql:";
	final String HOST = "//localhost:3306";
	final String DATA = "ikerg"; // database user and password
	connectTo(DRIVER, CONBASE, DATA, HOST, DATA, DATA);
    }

    /**
     * Metodo encargado de conectarse a la base de datos
     *
     * @param driver
     * @param baseConnection
     * @param database
     * @param host
     * @param user
     * @param password
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private void connectTo(String driver, String baseConnection,
	    String database, String host, String user, String password)
	    throws ClassNotFoundException, SQLException {
	Class.forName(driver);
	connection = DriverManager.getConnection(baseConnection + host + "/"
		+ database, user, password);
    }

    /**
     * Metodo encargado de crear las tablas necesarias
     *
     * @throws SQLException
     */
    public void crearTablas() throws SQLException {
	Statement st = connection.createStatement();
	try {
	    String sql = "drop table alumno";
	    int rs = st.executeUpdate(sql);
	    sql = "drop table ciclo";
	    rs = st.executeUpdate(sql);
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {

	    String sql = "create table ciclo (" + "codigo integer NOT NULL,"
		    + "titulo varchar(20), " + "horas integer,"
		    + "constraint codigo_pk PRIMARY KEY(codigo)" + ")";
	    int rs = st.executeUpdate(sql);
	    sql = "create table alumno (" + "dni char(9) NOT NULL,"
		    + "nombre varchar(20), " + "poblacion varchar(30),"
		    + "telefono char(9)," + "fechanac date,"
		    + "codciclo integer,"
		    + "constraint dni_pk PRIMARY KEY(dni)"
		    // +
		    // "constraint ciclo_fk FOREIGN KEY(codciclo) references ciclo (codigo) on delete cascade"
		    + ")";
	    rs = st.executeUpdate(sql);
	    st.close();
	}

    }

    /**
     * Metodo encargado de listar los alumnos
     *
     * @return la lista de alumnos Alumnos
     * @throws SQLException
     */
    public ArrayList<Alumno> listadoAlumnos() throws SQLException {
	ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	Statement st = connection.createStatement();
	String sql = "select * from alumno";
	ResultSet rs = st.executeQuery(sql);

	while (rs.next()) {
	    String dni = rs.getString("dni");
	    String nombre = rs.getString("nombre");
	    String poblacion = rs.getString("poblacion");
	    String telefono = rs.getString("telefono");
	    java.util.Date fechaNacimiento = rs.getDate("fechanac");
	    int codCiclo = rs.getInt("codciclo");
	    Alumno a = new Alumno(dni, nombre, poblacion, telefono,
		    fechaNacimiento, codCiclo);
	    listaAlumnos.add(a);
	}
	st.close();
	return listaAlumnos;
    }

    /**
     * Metodo encargado de buscar un alumno/ciclo
     *
     * @param dni
     * @return el Ciclo
     * @throws SQLException
     */
    public Ciclo buscaAlumno(String dni) throws SQLException {
	Statement st = connection.createStatement();
	String sql = "select * from alumno where dni ='" + dni + "'";
	ResultSet rs = st.executeQuery(sql);
	// primer metodo: devuelve alumno
	// Alumno a = null;
	// if (rs.next()) {
	// String nombre = rs.getString("nombre");
	// String poblacion = rs.getString("poblacion");
	// String telefono = rs.getString("telefono");
	// java.util.Date fechaNacimiento = rs.getDate("fechanac");
	// int codCiclo = rs.getInt("codciclo");
	// a = new Alumno(dni, nombre, poblacion, telefono, fechaNacimiento,
	// codCiclo);
	// }
	// return a;

	// segundo metodo, despues del cambio : devuelve diclo
	Ciclo c = null;
	if (rs.next()) {
	    int codCiclo = rs.getInt("codciclo");
	    String sql2 = "select * from ciclo where codigo ='" + codCiclo
		    + "'";
	    ResultSet rs2 = st.executeQuery(sql2);
	    if (rs2.next()) {
		String titulo = rs2.getString("titulo");
		int horas = rs2.getInt("horas");
		c = new Ciclo(codCiclo, titulo, horas);
	    }
	}
	st.close();
	return c;
    }

    /**
     * Metodo encargado de eliminar un alumno
     *
     * @param dni
     * @throws SQLException
     */
    public void eliminarAlumno(String dni) throws SQLException {
	Statement st = connection.createStatement();
	String sql = "delete from alumno where dni='" + dni + "'";
	int rs = st.executeUpdate(sql);
	if (rs == 0)
	    System.out.println("NO EXISTE ALUMNO CON TAL DNI");
	else
	    System.out.println("ALUMNO BORRADO");

	st.close();
    }

    /**
     * Metodo encargado de preparar la sentencia predefinida
     *
     * @throws SQLException
     */
    public void prepararSentencia() throws SQLException {
	insertStatment = connection
		.prepareStatement("insert into alumno values (?, ?, ?, ?, ?, ?)");
    }

    /**
     * Metodo encargado de insertar un alumno usando la presentencia
     *
     * @param a
     * @throws SQLException
     */
    public void insertarAlumnoPreSentencia(Alumno a) throws SQLException {
	String dni = a.getDni();
	String nombre = a.getNombre();
	String poblacion = a.getPoblacion();
	String telefono = a.getTelefono();
	java.util.Date fechaNacimiento = a.getFechaNacimiento();
	java.sql.Date fechaNacimientoSQL = new java.sql.Date(
		fechaNacimiento.getTime());
	int codCiclo = a.getCodCiclo();
	insertStatment.setString(1, dni);
	insertStatment.setString(2, nombre);
	insertStatment.setString(3, poblacion);
	insertStatment.setString(4, telefono);
	insertStatment.setDate(4, fechaNacimientoSQL);
	insertStatment.setInt(6, codCiclo);
    }

    /**
     * Metdodo encargado de insertar alumno sin presentencia
     *
     * @param a
     * @throws SQLException
     */
    public void insertarAlumno(Alumno a) throws SQLException {
	String dni = a.getDni();
	String nombre = a.getNombre();
	String poblacion = a.getPoblacion();
	String telefono = a.getTelefono();
	java.util.Date fechaNacimiento = a.getFechaNacimiento();
	String fechaNacimientoSQL = (new java.sql.Date(
		fechaNacimiento.getTime())).toString();
	int codCiclo = a.getCodCiclo();
	Statement st = connection.createStatement();
	String sql = "insert into alumno values ('" + dni + "', '" + nombre
		+ "', '" + poblacion + "', '" + telefono + "', '"
		+ fechaNacimientoSQL + "', '" + codCiclo + "')";
	int rs = st.executeUpdate(sql);
	if (rs > 0)
	    System.out.println("ALUMNO INSERTADO CON EXITO");

	st.close();
    }

    /**
     * Metodo encargado de modificar un alumno
     *
     * @param dniClave
     * @param a
     * @throws SQLException
     */
    public void modificarAlumno(String dniClave, Alumno a) throws SQLException {
	String dni = a.getDni();
	String nombre = a.getNombre();
	String poblacion = a.getPoblacion();
	String telefono = a.getTelefono();
	java.util.Date fechaNacimiento = a.getFechaNacimiento();
	String fechaNacimientoSQL = (new java.sql.Date(
		fechaNacimiento.getTime())).toString();
	int codCiclo = a.getCodCiclo();
	Statement st = connection.createStatement();
	String sql = "update alumno set dni='" + dni + "', nombre='" + nombre
		+ "', poblacion='" + poblacion + "', telefono='" + telefono
		+ "', fechanac='" + fechaNacimientoSQL + "', codciclo='"
		+ codCiclo + "' where dni='" + dniClave + "'";
	int rs = st.executeUpdate(sql);
	if (rs > 0)
	    System.out.println("ALUMNO ACTUALIZADO CON EXITO");
	else
	    System.out.println("IMPOSIBLE ACTUALIZAR ALUMNO");

	st.close();
    }
}
