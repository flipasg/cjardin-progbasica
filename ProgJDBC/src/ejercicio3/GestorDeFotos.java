/**
 *
 */
package ejercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Iker Garcia Ramirez
 * @date 28/5/2015
 *
 */
public class GestorDeFotos {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String CONBASE = "jdbc:mysql:";
    private static final String HOST = "//localhost:3306";
    private static final String BBDD = "ikerg";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection connection;

    public GestorDeFotos() throws SQLException, ClassNotFoundException {
	Class.forName(DRIVER);
	connection = DriverManager.getConnection(CONBASE + HOST + "/" + BBDD,
		USER, PASSWORD);
    }

    public Fotografo[] obtenerFotografos() throws SQLException {
	Fotografo[] fotografos = null;
	Statement st = connection.createStatement();
	String sql = "select count(*) from fotografos";
	ResultSet rs = st.executeQuery(sql);
	if (rs.next())
	    fotografos = new Fotografo[rs.getInt(1)];
	sql = "select * from fotografos";
	rs = st.executeQuery(sql);
	int i = 0;
	while (rs.next()) {
	    int idfotografo = rs.getInt("idfotografo");
	    String nombre = rs.getString("nombre");
	    boolean premiado = rs.getBoolean("premiado");
	    Fotografo f = new Fotografo(idfotografo, nombre, premiado);
	    fotografos[i] = f;
	    i++;

	}
	st.close();
	return fotografos;
    }

    public ArrayList<Foto> obtenerFotos(int fotografo, String fechap)
	    throws SQLException {
	ArrayList<Foto> fotos = new ArrayList<Foto>();
	Statement st = connection.createStatement();
	String sql = "select * from fotos where fecha>='" + fechap
		+ "' and idfotografo='" + fotografo + "'";
	ResultSet rs = st.executeQuery(sql);
	while (rs.next()) {
	    int idfoto = rs.getInt("idfoto");
	    String titulo = rs.getString("titulo");
	    java.util.Date fecha = new java.util.Date(rs.getDate("fecha")
		    .getTime());
	    String archivo = rs.getString("archivo");
	    int visualizaciones = rs.getInt("visualizaciones");
	    Foto f = new Foto(idfoto, titulo, fecha, archivo, visualizaciones,
		    fotografo);
	    fotos.add(f);
	}
	st.close();
	return fotos;
    }

    public void incrementarVisualizaciones(Foto f) throws SQLException {
	f.incrementarVisualizaciones();
	Statement st = connection.createStatement();
	String sql = "update fotos set visualizaciones="
		+ f.getVisualizaciones() + " where idfoto='" + f.getIdfoto()
		+ "'";
	st.executeUpdate(sql);
	st.close();

    }
}
