package paquete2d;

public class Circulo {
	float radio;
	
	public Circulo(float radio) {
		this.radio = radio;
	}
	
	public float area(){
		return (float)(Math.PI*radio*radio);
	}

}
