package oo11;

public class PruebaTriangulo {

	public static void main(String[] args) {
		Punto p1 = new Punto(5, -3);
		Punto p2 = new Punto(3, 3);
		Punto p3 = new Punto(-1, 8);
		
		Triangulo t1 = new Triangulo("HI", p1, p2, p3);
		
		System.out.println(t1.toString());
		System.out.println(t1.calcularArea());

	}

}
