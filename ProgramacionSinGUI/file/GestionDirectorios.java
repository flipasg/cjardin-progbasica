package ejarrays;

public class GestionDirectorios{
	Directorio[] rutas;
	
	public GestionDirectorios(int n){
		rutas = new Directorio[n];
	}
	
	public int ver(){
		int cont = 0;
		for(int i = 0; i<rutas.length; i++){
			if(rutas[i]!=null){
				cont++;
			}
		}
		for(int i = 0; i<=cont; i++){
			System.out.print(rutas[i]+" ");
		}
		System.out.println();
		return cont;
	}
	
	public boolean aniadeDirectorio(Directorio dir, int n){
		if(ver()==rutas.length){
			return false;
		}else{
			if(n>rutas.length){
				return false;
			}else{
				if(rutas[n]!=null){
					for(int i = ver(); i>=n; i--){
						rutas[i+1] = rutas[i];
					}
					rutas[n] = dir;
				}else{
					rutas[n] = dir;
				}
				return true;
			}
		}
	}
	
	private int tamanioTotal(){
		int sumTam = 0;
		for(int i = 0; i<ver(); i++){
			sumTam+=rutas[i].getTamanio();
		}
		return sumTam;
	}
	
	public void verTamanioTotal(){
		if(tamanioTotal()<1024){
			System.out.println(tamanioTotal()+" bytes");
		}else{
			if(tamanioTotal()==1024){
				System.out.println("1 Kbyte");
			}else{
				int kb = tamanioTotal()/1024;
				if(kb<1024){
					System.out.println(kb+" Kbytes");
				}else{
					int mb = kb/1024;
					if(mb==1024){
						System.out.println("1 Mbyte");
					}else{
						System.out.println(mb+" Mbytes");
					}
					
				}
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args){
		
	}

}
