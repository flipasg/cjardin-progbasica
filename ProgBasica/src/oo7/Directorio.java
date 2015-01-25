package oo7;

public class Directorio {
	private String nombre; // "c:/xxx/yyy/..."
	private int tamanio;
	private final static int MAXCAR = 40; 
	
	public Directorio(String nombre, int tamanio) {
		this.nombre = nombre;
		this.tamanio = tamanio;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
	
	void ver(){
		System.out.println("El directorio es "+nombre+" y su tamaño "+tamanio);
	}
	
	int niveles(){
		int cont = 1;
		for(int i = 0;i<nombre.length();i++){
			if(nombre.charAt(i)=='/'){
				cont++;
			}
		}
		return cont;
	}
	
	String ultimo(){
		String cad = "";
		boolean enc = false;
		int i = nombre.length()-1;
		while(i>=0 && !enc){
			if(nombre.charAt(i)=='/'){
				enc = true;
			}
			else{
				cad = nombre.charAt(i)+cad;
			}
			i--;
		}
		return cad;
	}
	
	Boolean caracterIlegal(){
		boolean enc = false;
		int i = 0;
		while(i<nombre.length() && !enc){
			if(nombre.charAt(i)=='*' || nombre.charAt(i)=='#' || nombre.charAt(i)=='@'){
				enc = true;
			}
			i++;
		}
		return enc;
	}
	
	String dirValido(){
		String cad = "";
		
		boolean s = false;
		if(nombre.charAt(1)!=':' || (nombre.charAt(0)<='a' && nombre.charAt(0)>='z') ||  (nombre.charAt(0)<='A' && nombre.charAt(0)>='Z')){
			cad+="No comienza por una unidad de disco\n";
		}
		if(nombre.length()>MAXCAR){
			cad+="Su nombre es demasiado largo\n";
		}
		if(this.caracterIlegal()){
			cad+="Tiene carácteres ilegales\n";
		}
		for(int i = 0;i<nombre.length() && !s;i++){
			if(nombre.charAt(i)=='/' && nombre.charAt(i+1)=='/'){
					cad+="Tiene '/' contiguos\n";
					s = true;
			}
		}
		if(cad==""){
			cad+="Ok";
		}
		return cad;
	}
	
	void compactarDir(){
		String cad = "";
		for(int i = 0;i<nombre.length();i++){
			if(nombre.charAt(i)!=' '){
				if(nombre.charAt(i)>='A' && nombre.charAt(i)<='Z'){
					cad+=(char) ('a'+(nombre.charAt(i)-'A'));
				}
				else{
					cad+=nombre.charAt(i);
				}
			}
		}
		
		nombre = cad;
		
	}
	
	public static void main(String[] args) {
		Directorio d1 = new Directorio("C:/programs/java/jre", 12301230);
		Directorio d2 = new Directorio("C:/Programs/Oracle/database home/bin", 890);
		
		d1.ver();
		d2.ver();
		
		d2.setTamanio(d2.tamanio+(d1.tamanio/2));
		
		if(d1.niveles()>d2.niveles()){
			d1.ver();
		}
		else{
			if(d1.niveles()<d2.niveles()){
				d2.ver();
			}
			else{
				System.out.println("Tienen los mismos niveles");
			}
		}
		
		System.out.println(d1.dirValido());
		System.out.println(d2.dirValido());
		
		if(d1.ultimo()!=d2.ultimo()){
			char car = 'X';
			d1.nombre = car+d1.nombre; //d1.setNombre(car+d1.nombre);
			d2.nombre = car+d2.nombre;
		}
		
		d1.ver();
		d2.ver();
		
		d1.compactarDir();
		d2.compactarDir();
		
		d1.ver();
		d2.ver();
		
	}



}
