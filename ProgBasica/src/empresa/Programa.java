package empresa;

class Programa {

	public static void main(String[] args) {
		Telefonomovil m1 = new Telefonomovil("677777777", 98);
		Trabajador t1 = new Trabajador("0101010101", "Me", 178, 67, 77, m1);
		
		System.out.println(t1.toString());
		
		t1.trabajar();
		t1.trabajar();
		
		System.out.println(t1.toString());

	}

}
