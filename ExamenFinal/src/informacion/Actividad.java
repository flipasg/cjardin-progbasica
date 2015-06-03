package informacion;

public class Actividad {
	private int id;
	private String nombre;
	private float costeMensual;
	private int capacidad;
	private String nombreMonitor;
	
	public Actividad(int id, String nombre, float costeMensual, int capacidad,
			String nombreMonitor) {
		this.id = id;
		this.nombre = nombre;
		this.costeMensual = costeMensual;
		this.capacidad = capacidad;
		this.nombreMonitor = nombreMonitor;
	}

	@Override
	public String toString() {
		String nombreAMostrar = nombre;
		if(nombreAMostrar.length()<20) {
			for (int i = nombreAMostrar.length(); i < 20; i++) {
				nombreAMostrar+=" ";
			}
		} else if(nombreAMostrar.length()>20) {
			nombreAMostrar = nombreAMostrar.substring(0, 20);
		}
		
		return nombreAMostrar + "(" + nombreMonitor + ")";
	}

	public float getCosteMensual() {
		return costeMensual;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public int getId() {
		return id;
	}
	
//	public static void main(String[] args) {
//		Actividad a = new Actividad(12, "Gimnasia de mantenimiento", 20f, 20, "Rosa Fernandez");
//		Actividad b = new Actividad(23, "Judo", 20f, 20, "Luis  Garcia");
//		System.out.println(a);
//		System.out.println(b);
//	}
	
	

}
