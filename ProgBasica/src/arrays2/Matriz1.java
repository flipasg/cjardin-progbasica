package arrays2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class Matriz1{
	private static final int NF = 10;
	private static final int NC = 15;
	private int nf;
	private int nc;
	private int[][] a;
	
	public Matriz1(){
		a = new int[NF][NC];
		nf = NF;
		nc = NC;
	}
	public Matriz1(int nf, int nc){
		a = new int[NF][NC];
		this.nf = nf;
		this.nc = nc;
	}
	
	public void cargarPorColumnas() throws IOException{
		cargar('c');
	}
	
	public void cargarPorFilas() throws IOException{
		cargar('f');
	}
	
	public void invertirPorColumnas() throws IOException{
		invertir('c');
	}
	
	public void invertirPorFilas() throws IOException{
		invertir('f');
	}
	
	public void intercambiarColumnas(int n1, int n2) throws IOException{
		intercambiar('c', n1, n2);
	}
	
	public void intercambiarFilas(int n1, int n2) throws IOException{
		intercambiar('f', n1, n2);
	}
	
	private void cargar(char c) throws IOException{
		int li = 0;
		int lj = 0;
		if(c=='f'){
			li = nf;
			lj = nc;
		}else{
			if(c=='c'){
				li = nc;
				lj = nf;
			}else{
				System.out.println("Imposible cargar");
			}
		}
		
		for(int i = 0; i<li; i++){
			for(int j = 0; j<lj; j++){
				if(c=='f'){
					System.out.println("Dime el valor para la fila: "+(i+1)+" y la columna: "+(j+1));
					a[i][j] = Consola.leeInt();
				}
				if(c=='c'){
					System.out.println("Dime el valor para la fila: "+(j+1)+" y la columna: "+(i+1));
					a[j][i] = Consola.leeInt();
				}
				
			}
		}
	}
	
	public void ver(){
		for(int i = 0; i<nf; i++){
			for(int j = 0; j<nc; j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private void invertir(char c){
		int li;
		int lj;
		int aux;
		if(c=='f'){
			li = nf;
			lj = nc;
		}else{
			if(c=='c'){
				li = nc;
				lj = nf;
			}else{
				li = 0;
				lj = 0;
				System.out.println("Imposible invertir");
			}
		}
		for(int i = 0; i<li; i++){
			for(int j = lj-1, j2 = 0; j>=j2; j--, j2++){
				if(c=='f'){
					aux = a[i][j];
					a[i][j] = a[i][j2];
					a[i][j2] = aux;
				}
				if(c=='c'){
					aux = a[j][i];
					a[j][i] = a[j][j2];
					a[j][j2] = aux;
				}
			}
		}
	}
	
	private boolean intercambiar(char c, int n1, int n2){
		if(c=='f'){
			int[] aux = new int[nc];
			aux = a[n1-1];
			a[n1-1] = a[n2-1];
			a[n2-1] = aux;
			return true;
		}else{
			if(c=='c'){
				int aux = 0;
				for(int i = 0; i<nc; i++){
					aux = a[n1-1][i];
					a[n1-1][i] = a[n2-1][i];
					a[n2-1][i] = aux;
				}
				return true;
			}else{
				return false;
			}
		}
	}
	
	public int[] mayorFila(){
		int suma = 0;
		float media = 0;
		float mediaMax = 0;
		int iMax = 0;
		for(int i = 0; i<nf; i++){
			suma = 0;
			media = 0;
			for(int j = 0; j<nc; j++){
				suma+=a[i][j];
			}
			media = (float)suma/nc;
			if(media>mediaMax){
				iMax = i;
			}
		}
		return a[iMax];
	}
	
	public int[] negativos(){
		ArrayList<Integer> negativos = new ArrayList<Integer>();
		for(int i = 0; i<nf; i++){
			for(int j = 0; j<nc; j++){
				if(a[i][j]<0){
					negativos.add(Integer.valueOf(a[i][j]));
				}
			}
		}
		ListIterator<Integer> i = negativos.listIterator();
		int nNegativos = negativos.size();
		int[] aneg = new int[nNegativos];
		int cont = 0;
		while(i.hasNext() && cont<nNegativos ){
			aneg[cont] = i.next().intValue();
			cont++;
		}
		
		return aneg;
	}

}
