package empresa;

class Programa2 {

	public static void main(String[] args) {
		Telefonomovil m2 = new Telefonomovil("688888888", 100);
		Trabajador d = new Trabajador("0202020202", "Dueño", 199, 90, 190000, m2);
		
		Telefonomovil m1 = new Telefonomovil("677777777", 98);
		Trabajador t1 = new Trabajador("0101010101", "Me", 178, 67, 77, m1);
		
		Empresa e1 = new Empresa("Despilfarro", 100, d);
		
		e1.contratarGerente(t1);
		
		System.out.println(e1.toString());
		
		e1.trabajar();
		e1.trabajar();
		
		System.out.println(e1.toString());

	}

}
