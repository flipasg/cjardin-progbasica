package ejerciciocalc;

public class Calculadora {
    private double resultado;
    
    public Calculadora() {
	resultado = 0;
    }
    
    /**
     * Método obtener : getResultado
     * @return el resultado de la clase
     */
    public double getResultado() {
        return resultado;
    }

    /**
     * Método establecer : setResultado
     * @param resultado para establecer resultado
     */
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public void suma(double numero) {
	resultado+=numero;
    }
    
    public void resta(double numero) {
	resultado-=numero;
    }
    
    public void multiplicacion(double numero) {
	resultado*=numero;
    }
}
