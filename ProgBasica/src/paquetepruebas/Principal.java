package paquetepruebas;

import paquete2d.*;
import paquete3d.*;

public class Principal {

	public static void main(String[] args) {
		Circulo c1 = new Circulo(3.22f);
		Rectangulo r1 = new Rectangulo(2f, 5.5f);
		Cilindro cil1 = new Cilindro(2.34f, 6.7f);
		Esfera e1 = new Esfera(2.34f, 6.7f);
		
		System.out.println("Circulo: "+c1.area()+" Rectangulo: "+r1.area()+" Cilindro: "+cil1.volumen()+" Esfera: "+e1.volumen());
	}

}
