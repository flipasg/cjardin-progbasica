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
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String CONBASE = "jdbc:mysql:";
    private static final String HOST = "//localhost:3306";
    private static final String BBDD = "ikerg";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection connection;
    private PreparedStatement insertStatment;

    /**
     * Constructor de la clase GestorAlumnos
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public GestorAlumnos() throws ClassNotFoundException, SQLException {
	connectTo(DRIVER, CONBASE, BBDD, HOST, USER, PASSWORD);
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
     */
    private void connectTo(String driver, String baseConnection,
	    String database, String host, String user, String password) {
	try {
	    Class.forName(driver);
	    connection = DriverManager.getConnection(baseConnection + host
		    + "/" + database, user, password);
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (SQLException e) {
	    e.printStackTrace();
	}

    }

    /**
     * Metodo encargado de crear las tablas necesarias
     *
     */
    public String crearTablas() {
	Statement st = null;
	try {
	    st = connection.createStatement();
	    // // String sql = "drop table alumno";
	    // // int rs = st.executeUpdate(sql);
	    // String sql2 = "drop table ciclo";
	    // int rs2 = st.executeUpdate(sql2);
	    String sql3 = "create table ciclo (" + "codigo integer NOT NULL,"
		    + "titulo varchar(20), " + "horas integer,"
		    + "constraint codigo_pk PRIMARY KEY(codigo)" + ")";
	    int rs3 = st.executeUpdate(sql3);
	    String sql4 = "create table alumno ("
		    + "dni char(9) NOT NULL,"
		    + "nombre varchar(20), "
		    + "poblacion varchar(30),"
		    + "telefono char(9),"
		    + "fechanac date,"
		    + "codciclo integer,"
		    + "constraint dni_pk PRIMARY KEY(dni),"
		    + "constraint ciclo_fk FOREIGN KEY(codciclo) references ciclo (codigo) on delete cascade"
		    + ")";
	    int rs4 = st.executeUpdate(sql4);
	    st.close();
	} catch (SQLException e) {
	    return e.getMessage();
	}

	return "Tablas creadas con exito";

    }

    /**
     * Metodo encargado de listar los alumnos
     *
     * @return la lista de alumnos Alumnos
     */
    public ArrayList<Alumno> listadoAlumnos() {
	ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	Statement st = null;
	try {
	    st = connection.createStatement();
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

	} catch (SQLException e) {
	}
	return listaAlumnos;

    }

    /**
     * Metodo encargado de buscar un alumno/ciclo
     *
     * @param dni
     * @return el Alumno
     */
    public Alumno buscaAlumno(String dni) {
	Statement st = null;
	Alumno a = null;
	try {
	    st = connection.createStatement();
	    String sql = "select * from alumno where dni ='" + dni + "'";
	    ResultSet rs = st.executeQuery(sql);

	    if (rs.next()) {
		String nombre = rs.getString("nombre");
		String poblacion = rs.getString("poblacion");
		String telefono = rs.getString("telefono");
		java.util.Date fechaNacimiento = rs.getDate("fechanac");
		int codCiclo = rs.getInt("codciclo");
		a = new Alumno(dni, nombre, poblacion, telefono,
			fechaNacimiento, codCiclo);
	    }
	    st.close();
	} catch (SQLException e) {
	}

	return a;

    }

    /**
     * Metodo encargado de buscar un alumno/ciclo
     *
     * @param dni
     * @return el Ciclo
     */
    public Ciclo buscaCiclo(int ciclo) {
	Statement st = null;
	Ciclo c = null;
	try {
	    st = connection.createStatement();
	    String sql = "select * from ciclo where codciclo =" + ciclo + "";
	    ResultSet rs = st.executeQuery(sql);

	    if (rs.next()) {
		String titulo = rs.getString("titulacion");
		int horas = rs.getInt("horas");
		java.util.Date fechaNacimiento = rs.getDate("fechanac");
		int codCiclo = rs.getInt("codciclo");
		c = new Ciclo(ciclo, titulo, horas);
	    }
	    st.close();
	} catch (SQLException e) {
	}

	return c;

    }

    /**
     * Metodo que devuelve un array de ciclos
     *
     * @return ciclos
     */
    public Ciclo[] todosCiclos() {

	Statement st;
	Ciclo[] ciclos = null;
	try {
	    String sql1 = "select count(*) from ciclo";
	    String sql2 = "select * from ciclo";
	    st = connection.createStatement();
	    ResultSet rs = st.executeQuery(sql1);
	    if (rs.next())
		ciclos = new Ciclo[rs.getInt(1)];
	    rs = st.executeQuery(sql2);

	    int i = 0;
	    while (rs.next()) {
		int codigo = rs.getInt("codigo");
		String titulo = rs.getString("titulo");
		int horas = rs.getInt("horas");
		Ciclo c = new Ciclo(codigo, titulo, horas);
		ciclos[i] = c;
		i++;
	    }

	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	}

	return ciclos;
    }

    /**
     * Metodo encargado de eliminar un alumno
     *
     * @param dni
     */
    public String eliminarAlumno(String dni) {
	Statement st = null;
	int rs = 0;
	try {
	    st = connection.createStatement();
	    String sql = "delete from alumno where dni='" + dni + "'";
	    rs = st.executeUpdate(sql);

	    st.close();
	} catch (SQLException e) {
	    return e.getMessage();
	}
	if (rs == 0)
	    return "No existe alumno con tal dni";

	return "Alumnos eliminados con exito";
    }

    /**
     * Metodo encargado de preparar la sentencia predefinida
     *
     */
    public String prepararSentencia() {
	try {
	    insertStatment = connection
		    .prepareStatement("insert into alumno values (?, ?, ?, ?, ?, ?)");
	} catch (SQLException e) {
	    return e.getMessage();
	}

	return "Sentencia preparada con exito";
    }

    /**
     * Metodo encargado de insertar un alumno usando la presentencia
     *
     * @param a
     */
    public String insertarAlumnoPreSentencia(Alumno a) {
	String dni = a.getDni();
	String nombre = a.getNombre();
	String poblacion = a.getPoblacion();
	String telefono = a.getTelefono();
	java.util.Date fechaNacimiento = a.getFechaNacimiento();
	java.sql.Date fechaNacimientoSQL = new java.sql.Date(
		fechaNacimiento.getTime());
	int codCiclo = a.getCodCiclo();
	try {
	    insertStatment.setString(1, dni);
	    insertStatment.setString(2, nombre);
	    insertStatment.setString(3, poblacion);
	    insertStatment.setString(4, telefono);
	    insertStatment.setDate(4, fechaNacimientoSQL);
	    insertStatment.setInt(6, codCiclo);
	} catch (SQLException e) {
	    return e.getMessage();
	}

	return "Alumno insertado con exito";

    }

    /**
     * Metdodo encargado de insertar alumno sin presentencia
     *
     * @param a
     */
    public String insertarAlumno(Alumno a) {
	String dni = a.getDni();
	String nombre = a.getNombre();
	String poblacion = a.getPoblacion();
	String telefono = a.getTelefono();
	java.util.Date fechaNacimiento = a.getFechaNacimiento();
	String fechaNacimientoSQL = (new java.sql.Date(
		fechaNacimiento.getTime())).toString();
	int codCiclo = a.getCodCiclo();
	Statement st = null;
	int rs = 0;
	try {
	    st = connection.createStatement();
	    String sql = "insert into alumno values ('" + dni + "', '" + nombre
		    + "', '" + poblacion + "', '" + telefono + "', '"
		    + fechaNacimientoSQL + "', '" + codCiclo + "')";
	    rs = st.executeUpdate(sql);
	    st.close();
	} catch (SQLException e) {
	    return e.getMessage();
	}

	return "Alumno insertado con exito";

    }

    /**
     * Metodo encargado de modificar un alumno
     *
     * @param dniClave
     * @param a
     */
    public String modificarAlumno(String dniClave, Alumno a) {
	String dni = a.getDni();
	String nombre = a.getNombre();
	String poblacion = a.getPoblacion();
	String telefono = a.getTelefono();
	java.util.Date fechaNacimiento = a.getFechaNacimiento();
	String fechaNacimientoSQL = (new java.sql.Date(
		fechaNacimiento.getTime())).toString();
	int codCiclo = a.getCodCiclo();
	Statement st = null;
	int rs = 0;
	try {
	    st = connection.createStatement();
	    String sql = "update alumno set dni='" + dni + "', nombre='"
		    + nombre + "', poblacion='" + poblacion + "', telefono='"
		    + telefono + "', fechanac='" + fechaNacimientoSQL
		    + "', codciclo='" + codCiclo + "' where dni='" + dniClave
		    + "'";
	    rs = st.executeUpdate(sql);
	    st.close();
	} catch (SQLException e) {
	    return e.getMessage();
	}

	if (rs > 0)
	    return "Alumno actualizado con exito";
	return "Imposible actualizar alumno";

    }

    /**
     * Metodo que cierra la conexion con la base de datos
     */
    public String finalizar() {
	try {
	    connection.close();
	} catch (SQLException e) {
	    return e.getMessage();
	}

	return "Conexion finalizada con exito";
    }
}
