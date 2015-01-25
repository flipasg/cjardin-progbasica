package oo10test;

import oo10.*;

public class TestFigura {

	public static void main(String[] args) {
		Circulo c1 = new Circulo(2);
		Cuadrado cu1 = new Cuadrado(3);
		Rectangulo r1 = new Rectangulo(4, 5);
		System.out.println(Figura.getAreaTotal());
		
		Circulo c2 = new Circulo(2);
		Circulo c3 = new Circulo(3);
		System.out.println(Circulo.getAreaTotal());

	}

}
