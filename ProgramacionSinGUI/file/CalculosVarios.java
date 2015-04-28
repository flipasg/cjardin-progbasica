package oo8;

import java.io.IOException;

import oo6.Consola;

public class CalculosVarios {

	public static void main(String[] args) throws IOException {
		String str_int1 = "12";
		String str_int2 = "34";
		
		System.out.println(str_int1+str_int2);
		System.out.println(Integer.parseInt(str_int1)+Integer.parseInt(str_int2));
		
		String str_f1 = "15.5";
		String str_f2 = "4.5f";
		
		System.out.println(str_f1+str_f2);
		System.out.println(Float.parseFloat(str_f1)+Float.parseFloat(str_f2));
		
		final String cs1 = "30";
		final int ci1 = 20;
		
		int n1 = ci1;
		int n2 = Integer.parseInt(cs1);
		int nr = n1*n2;
		
		System.out.println(nr);
		
		final float cf1 = 2.3f;
		System.out.println(Math.ceil(cf1));
		
		System.out.println(Math.round(2*Math.PI));
		
		System.out.println(Math.abs(Math.sin((-2*Math.PI)/180)));
		
		System.out.println(Math.min(Math.sin((180*Math.PI)/180), ((270*Math.PI)/180)));
		
		for(int i = 0;i<10;i++){
			System.out.println(Math.pow(3, i));
		}
		
		System.out.println((int)(Math.random()*11));
		System.out.println((int)(Math.random()*(11))+10);
		
		for(int i = 0;i<5;i++){
			System.out.println((int)(Math.random()*(11))+10);
		}
		
		System.out.println("Dime un numero");
		int n = Consola.leeInt();
		
		for(int i = 0;i<n;i++){
			System.out.println(Math.random()*6);
		}
		
		
		System.out.println((int)(Math.random()*(31))-20);
		System.out.println((char)((int)(Math.random()*(26))+65));
	}

}
