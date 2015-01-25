package oo11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PruebaPunto {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Dime la primera coordenada:");
		double c1 = Double.parseDouble(b.readLine());
		System.out.println("Dime la segunda coordenada:");
		double c2 = Double.parseDouble(b.readLine());
		Punto p1 = new Punto(c1, c2);
		
		System.out.println(p1.toString());
		System.out.println(p1.distanciaOrigen());
		System.out.println(p1.getY());
		System.out.println(p1.calcularCuadrante());
		
		
	}

}
