package oo11;

public class PruebaCuadrado {

	public static void main(String[] args) {
		Punto p1 = new Punto(5, -3);
		Punto p2 = new Punto(9, 3);
		
		Cuadrado c1 = new Cuadrado("HihO", p1, p2);
		System.out.println(c1.toString());
		System.out.println(c1.calcularArea());

	}

}
