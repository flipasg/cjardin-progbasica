package ej3;

public class SumaEnteros {
	public static void main(String[] args) {
		int suma = 0;
		int contadosNoEnteros = 0;
		for (int i = 0; i < args.length; i++) {
			try {
				suma+=Integer.parseInt(args[i]);
			} catch (NumberFormatException e) {
				
				System.out.println(args[i] + " no se pudo sumar");
				contadosNoEnteros++;
				
			}
		}
		System.out.println(suma);
		System.out.println(contadosNoEnteros);
	}
}
