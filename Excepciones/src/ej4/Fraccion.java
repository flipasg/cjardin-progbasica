package ej4;

public class Fraccion {
	private int numerador;
	private int denominador;
	private final static char SIMB = '/';
	
	public Fraccion(int numerador, int denominador) throws FraccionExcepcion {
		if(denominador == 0) throw new FraccionExcepcion("No se puede instanciar fraccion con denominador 0");
		this.numerador = numerador;
		this.denominador = denominador;
		simplificar();
	}

	public String toString() {
		return numerador + "" + SIMB + "" + denominador ;
	}
	
	private static int calcularMCD(int num, int den){
		//Calcular Maximo Común Divisor
		if (den == 0) return num;
		else return calcularMCD(num, num%den);
	}
	private void simplificar() throws FraccionExcepcion{
		int mcd = calcularMCD(numerador, denominador);
		if (mcd == 0) throw new FraccionExcepcion("El resultado de esta operacion es una fraccion invalida");
		numerador/=mcd;
		denominador/=mcd;
	}
	
	public Fraccion sumar(Fraccion f) throws FraccionExcepcion{
		return new Fraccion(numerador*f.denominador+f.numerador*denominador, denominador*f.denominador);
	}
	
	public Fraccion restar(Fraccion f) throws FraccionExcepcion{
		return new Fraccion(numerador*f.denominador-f.numerador*denominador, denominador*f.denominador);
	}
	
	public Fraccion multiplicar(Fraccion f) throws FraccionExcepcion{
		return new Fraccion(numerador*f.numerador, denominador*f.denominador);
	}
	
	public Fraccion dividir(Fraccion f) throws FraccionExcepcion{
		return new Fraccion(numerador*f.denominador, denominador*f.numerador);
	}
	
}
