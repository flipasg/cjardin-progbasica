package ej4;

public class Principal {

	public static void main(String[] args) {
		try {
			Fraccion f = new Fraccion(1, 0);
		} catch (FraccionExcepcion e) {
			System.err.println(e.getMessage());
		}
		System.out.println();
		try {
			Fraccion f = new Fraccion(54, 45);
			Fraccion f2 = new Fraccion(0, 5);
			f.dividir(f2);
		} catch (FraccionExcepcion e) {
			System.err.println(e.getMessage());
		}
		System.out.println();
		try {
			Fraccion f = new Fraccion(4, 5);
			Fraccion f2 = new Fraccion(1, 5);
			System.out.println(f.dividir(f2));
		} catch (FraccionExcepcion e) {
			System.err.println(e.getMessage());
		}
		System.out.println();
		try {
			Fraccion f = new Fraccion(1, 2);
			Fraccion f2 = new Fraccion(1, 5);
			System.out.println(f.restar(f2));
		} catch (FraccionExcepcion e) {
			System.err.println(e.getMessage());
		}
		
		try {
			Fraccion f = new Fraccion(1, 2);
			Fraccion f2 = new Fraccion(1, 5);
			System.out.println(f.sumar(f2));
		} catch (FraccionExcepcion e) {
			System.err.println(e.getMessage());
		}

	}

}
