package ej1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DividePorCero {
	public static void main(String[] args) {
		BufferedReader buffReader = null;
		try {
			buffReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Dime dos enteros: ");
			System.out.println("El primero - ");
			int num1 = Integer.parseInt(buffReader.readLine());
			System.out.println("El segundo - ");
			int num2 = Integer.parseInt(buffReader.readLine());
			if(num2 == 0) throw new IllegalArgumentException("Error: división por cero");
			
			System.out.println(num1/num2);
		} catch (NumberFormatException  e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
