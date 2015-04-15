package ejerciciocalc;

public class Calculadora {
    
    public double suma(double num1, double num2) {
	return num1+num2;
    }
    
    public double resta(double num1, double num2) {
	return num1-num2;
    }
    
    public double division(double num1, double num2) {
	if(num2==0) throw new ArithmeticException("No se puede dividir entre 0");
	return num1/num2;
    }
    
    public double multiplicacion(double num1, double num2) {
	return num1*num2;
    }
    
    public double resto(double num1, double num2) {
	return num1%num2;
    }
    
    public double factorial(double num1) {
	double fact = num1;
	for (int i = 2; i < num1; i++) {
	    fact*=i;
	}
	
	return fact;
    }
}
