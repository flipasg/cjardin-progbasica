/**
 *
 */
package ej2wamp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * @author Iker Garcia Ramirez
 * @date 19/5/2015
 *
 */
public class FilmSQLConnector {
    private Connection connection;

    /**
     * @param proyection
     * @return if insert is possible
     * @throws SQLException
     */
    public boolean insertProyection(Proyection proyection) throws SQLException {
	String id = proyection.getId();
	Date date = proyection.getDate();
	String place = proyection.getPlace();
	Film film = proyection.getFilm();
	System.out.println(date.toString());

	String sqlQuery = "insert into proyections values('" + id + "', '"
		+ new java.sql.Date(date.getTime()).toString() + "', '" + place
		+ "', " + film.getId() + ")";
	Statement statment = connection.createStatement();

	if (statment.executeUpdate(sqlQuery) > 0) {
	    return true;
	}

	return false;

    }

    public boolean insertFilm(Film film) throws SQLException {
	String name = film.getName();
	int year = film.getYear();
	int taking = film.getTaking();
	boolean success = film.isSuccess();

	String sqlQuery = "insert into films(name, year, taking, success) values('"
		+ name + "', " + year + ", " + taking + ")";
	Statement statment = connection.createStatement();

	if (statment.executeUpdate(sqlQuery) > 0) {
	    return true;
	}

	return false;

    }

    /**
     * @param driver
     * @param baseConnection
     * @param database
     * @param host
     * @param user
     * @param password
     * @return if connection is possible
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean connectTo(String driver, String baseConnection,
	    String database, String host, String user, String password)
		    throws ClassNotFoundException, SQLException {
	Class.forName(driver);
	connection = DriverManager.getConnection(baseConnection + host + "/"
		+ database, user, password);

	if (connection != null)
	    return true;

	return false;
    }

    public static void main(String[] args) {
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String CONBASE = "jdbc:mysql:";
	final String HOST = "//172.20.102.120:3306";
	final String DATA = "ikerg"; // database user and password
	try {
	    FilmSQLConnector fqc = new FilmSQLConnector();
	    fqc.connectTo(DRIVER, CONBASE, DATA, HOST, DATA, DATA);
	    System.out.println(System.currentTimeMillis());
	    Film film = new Film(1, "Malditos Bastardos", 2010, 100000, true);
	    Proyection proyection = new Proyection("abcd", new Date(
		    System.currentTimeMillis()), "Yelmo Cineplex", film);
	    fqc.insertProyection(proyection);
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}