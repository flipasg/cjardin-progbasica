package arrays2;

import java.io.IOException;

import consola.Consola;

public class Ejercicio1 {
	private int[][] alumnos;
	
	public Ejercicio1(int n, int m){
		alumnos = new int[n][m];
	}
	
	public void rellenar() throws IOException{
		for (int i = 0; i < alumnos[i].length; i++) {
			System.out.println("Dime las notas de la "+(i+1)+" asignatura");
			for (int j = 0; j < alumnos.length; j++) {
				System.out.println("Nota para el alumno "+(j+1));
				alumnos[i][j]= Consola.leeInt();
			}
		}
	}
	
	public int mediaAlumno(int n){
		int suma = 0;
		for (int i = 0; i < alumnos.length; i++) {
			suma+=alumnos[n-1][i];
		}
		
		return suma/alumnos[n-1].length;
	}
	
	public int[] notasMaximas(){
		
		int[] notasMaximas = new int[alumnos.length];
		for (int i = 0; i < alumnos.length; i++) {
			int notaMaxima = 0;
			for (int j = 0; j < alumnos[i].length; j++) {
				if(notaMaxima<alumnos[i][j]){
					notaMaxima = alumnos[i][j];
				}
			}
			notasMaximas[i] = notaMaxima;
		}
		return notasMaximas;
	}
	
	public int[][] tipoNotas(){
		int[][] tipoNotas = new int[alumnos.length][4];
		for (int i = 0; i < alumnos.length; i++) {
			int contSuspenso = 0;
			int contAprobado = 0;
			int contNotable = 0;
			int contSobresaliente = 0;
			for (int j = 0; j < alumnos[i].length; j++) {
				if(alumnos[i][j]<5){
					contSuspenso++;
				}else{
					if(alumnos[i][j]<7){
						contAprobado++;
					}else{
						if(alumnos[i][j]<9){
							contNotable++;
						}else{
							contSobresaliente++;
						}
					}
				}
			}
			int cont = 0;
			for (int j = 0; j < tipoNotas[j].length; j++) {
				if(j==0){
					cont = contSuspenso;
				}else{
					if(j==1){
						cont = contAprobado;
					}else{
						if(j==2){
							cont = contNotable;
						}else{
							cont = contSobresaliente;
						}
					}
				}
				tipoNotas[i][j] = cont;
				
			}
		}
		return tipoNotas;
	}
	
	public void verAlumnos(){
		System.out.print("\t |");
		for (int i = 0; i < alumnos[0].length; i++) {
			System.out.print("Asignatura "+(i+1)+"\t|");
		}
		System.out.println();
		ver(alumnos);
	}
	
	public void verTipoNotas(){
		String tipo = "";
		System.out.print("\t |");
		for (int i = 0; i < 4; i++) {
			if(i==0){
				tipo = "Suspenso";
			}else{
				if(i==2){
					tipo = "Aprobado";
				}else{
					if(i==3){
						tipo = "Notable";
					}else{
						tipo = "Sobresaliente";
					}
				}
			}
			System.out.print(tipo+(i+1)+"\t|");
		}
		System.out.println();
		ver(tipoNotas());
	}
	
	public void verNotasMaximas(){
		for (int i = 0; i < notasMaximas().length; i++) {
			System.out.print("Alumno "+(i+1)+"\t|"+notasMaximas()[i]);
		}
	}
	
	private void ver(int[][] a){
		for (int i = 0; i < a.length; i++) {
			System.out.print("Alumno "+(i+1)+" |");
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]+"\t\t|");
			}
			System.out.println();
		}
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Dime el número de alumnos");
		int n = Consola.leeInt();
		System.out.println("Dime el número de asignaturas");
		int m = Consola.leeInt();
		
		Ejercicio1 ej1 = new Ejercicio1(n, m);
		ej1.verAlumnos();
		
	}

}
