package paquete3d;

public class Esfera extends Cilindro{
	float radio, altura;
	
	public Esfera(float radio, float altura) {
		super(radio, altura);
	}
	
	public float volumen(){
		return (2*super.volumen())/3;
	}
}
