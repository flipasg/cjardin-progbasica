package paquete3d;

import paquete2d.*;

public class Cilindro {
	float radio, altura;
	
	public Cilindro(float radio, float altura) {
		this.radio = radio;
		this.altura = altura;
	}
	
	public float volumen(){
		Circulo c1 = new Circulo(radio);
		return c1.area()*altura;
	}
}
