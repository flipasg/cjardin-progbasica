package paquete2d;

public class Rectangulo {
	float base, altura;
	
	public Rectangulo(float base, float altura) {
		this.base = base;
		this.altura = altura;
	}

	public float area(){
		return base*altura;
	}
}
