package basesdedatos;

import informacion.Actividad;
import informacion.ResultadoMatricula;
import informacion.Socio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorBD {
	private Connection conn;
	
	
	public GestorBD() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://172.20.102.120:3306/ikergimnasio","ikerg","ikerg");
		} catch (SQLException e) {} catch (ClassNotFoundException e) {}
	}
	
	public Socio login(String dni, String contrasenia) {
		Socio s = null;
		String sql = "select * from socios where dni='" + dni + "'";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellidosTexto = rs.getString("apellidos");
				String[] apellidos = apellidosTexto.split(" ");
				String contraseniaBuena = "";
				if(nombre.length()>3) {
					contraseniaBuena += nombre.substring(0, 3);
				} else {
					contraseniaBuena += nombre;
				}
				
				for (int i = 0; i < apellidos.length; i++) {
					contraseniaBuena += apellidos[i].charAt(0);
				}
				String nombreCompleto = nombre + apellidosTexto;
				if(contrasenia.equalsIgnoreCase(contraseniaBuena)) {
					return new Socio(dni, nombreCompleto, rs.getString("tfno_contacto"));
				} 
			}
			st.close();
		} catch (SQLException e) {}
		
		
		return s;
	}
	
	public Actividad[] actividades() {
		Actividad[] actividades = null;

		try {
			String sqlCantidadActividades = "select count(*) from actividades";
			String sqlTodasLasActividades = "select * from actividades";
			Statement stCantidad = conn.createStatement();
			ResultSet rsCantidad = stCantidad.executeQuery(sqlCantidadActividades);
			if(rsCantidad.next()) {
				actividades = new Actividad[rsCantidad.getInt(1)];
				Statement stActividades = conn.createStatement();
				ResultSet rsActividades = stActividades.executeQuery(sqlTodasLasActividades);
				int i = 0;
				while(rsActividades.next()) {
					int idMonitor = rsActividades.getInt("monitor_id");
					int idActividad = rsActividades.getInt("id");
					String nombreActividad = rsActividades.getString("nombre");
					float coste = rsActividades.getFloat("coste_mensual");
					int capacidad = rsActividades.getInt("capacidad");
					String sqlMonitor = "select * from monitores where id=" + idMonitor;
					Statement stMonitor = conn.createStatement();
					ResultSet rsMonitor = stMonitor.executeQuery(sqlMonitor);
					String nombreMonitor = null;
					if(rsMonitor.next()) {
						nombreMonitor = rsMonitor.getString("nombre") + " " + rsMonitor.getString("apellido");
					}
					stMonitor.close();
					actividades[i] = new Actividad(idActividad, nombreActividad, coste, capacidad, nombreMonitor);
					i++;
				}
				stActividades.close();
			}
			
			stCantidad.close();
			
		} catch (SQLException e) {}
		
		return actividades;
		
	}
	
	public ResultadoMatricula matricular(Socio s, Actividad a) {
		ResultadoMatricula rm = null;
		try {
			boolean exito = false;
			String mensaje = null;
			String sqlOcupacionActividad = "select count(*) from participa where actividad_id=" + a.getId() + " group by actividad_id";
			String sqlSocioActividad = "select * from participa where actividad_id= " + a.getId() + " and socio_dni='" + s.getDni() + "'";
			Statement stSocioActividad = conn.createStatement();
			ResultSet rsSocioActividad = stSocioActividad.executeQuery(sqlSocioActividad);
			if(!rsSocioActividad.next()) {
				Statement stOcupacionActividad = conn.createStatement();
				ResultSet rsOcupacionActividad = stOcupacionActividad.executeQuery(sqlOcupacionActividad);
				if(rsOcupacionActividad.next()) {
					int plazasOcupadas = rsOcupacionActividad.getInt(1);
					if(plazasOcupadas<a.getCapacidad()) {
						exito = true;
						mensaje = "Matriculado en " + a.getNombre();
						insertarMatricula(s, a);
					} else {
						mensaje = "No quedan plazas en esta actividad";
					}
				}
			} else {
				mensaje = s + "\nya esta registrado en esta actividad";
			}
			stSocioActividad.close();
			rm = new ResultadoMatricula(exito, mensaje);
		} catch (SQLException e) {}
		
		return rm;

	}
	
	public void establecerCuota(Socio s, float total) {
		
		try {
			String sqlUpdate = "update socios set cuota=cuota+? where dni=?";
			PreparedStatement ps = conn.prepareStatement(sqlUpdate);
			ps.setFloat(1, total);
			ps.setString(2, s.getDni());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void insertarMatricula(Socio s, Actividad a) {

		try {
			java.util.Date fechaHoy = new java.util.Date();
			java.sql.Date fechaSql = new java.sql.Date(fechaHoy.getTime());
			String sqlInsercion = "insert into participa values(" + a.getId() + ", '" + s.getDni() + "', '" + fechaSql + "')";
			Statement stInsercion = conn.createStatement();
			int rsInsercion = stInsercion.executeUpdate(sqlInsercion);
			stInsercion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void desconectar() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}

}
