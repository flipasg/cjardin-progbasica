package oo11;

public class PruebaCuadrado {

	public static void main(String[] args) {
		Punto p1 = new Punto(-3, -2);
		Punto p2 = new Punto(4, 2);
		
		Cuadrado c1 = new Cuadrado("HihO", p1, p2);
		System.out.println(c1.toString());
		System.out.println(c1.calcularArea());

	}

}
