/**
 * 
 */
package EjerOO1;

/**
 * @author ik010137ad
 *
 */
public class NumCapic {
	long num;
	boolean esCapicua;
	NumCapic(){
		
	}
	NumCapic(long num){
		this.num = num;
		if(this.capicua()){
			esCapicua = true;
		}
		else{
			esCapicua = false;
		}
	}
	int cantDigitos(){
		long aux;
		int cont;
		
		aux = num;
		cont = 0;
		while(aux!=0){
			aux/=10;
			cont++;
		}
		return cont;
	}
	int digitoEnPosicion(int p){
		int contD, dig;
		long aux;
		
		aux = num;
		contD = 0;
		dig = 0;
		while(contD<p){
			dig = (int)aux%10;
			aux/=10;
			contD++;
		}
		
		return dig;
	}
	boolean capicua(){
		int cont = 1;
		boolean capic = false;
		
		while(cont<=((cantDigitos()/2))){
			if(digitoEnPosicion(cont)==digitoEnPosicion(cantDigitos()-(cont-1))){
				capic = true;
			}
			else{
				capic = false;
			}
			cont++;
		}
		return capic;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NumCapic nc1 = new NumCapic(5775);
		if(nc1.esCapicua){
			System.out.println(nc1.num+" es capicua");
		}
		else{
			System.out.println(nc1.num+" no es capicua");
		}
		
		NumCapic nc2 = new NumCapic(57375);
		if(nc2.esCapicua){
			System.out.println(nc2.num+" es capicua");
		}
		else{
			System.out.println(nc2.num+" no es capicua");
		}
		
		NumCapic nc3 = new NumCapic(574375);
		if(nc3.esCapicua){
			System.out.println(nc3.num+" es capicua");
		}
		else{
			System.out.println(nc3.num+" no es capicua");
		}
		
		NumCapic nc4 = new NumCapic(579876675);
		if(nc4.esCapicua){
			System.out.println(nc4.num+" es capicua");
		}
		else{
			System.out.println(nc4.num+" no es capicua");
		}
		
		NumCapic nc5 = new NumCapic(2222);
		if(nc5.esCapicua){
			System.out.println(nc5.num+" es capicua");
		}
		else{
			System.out.println(nc5.num+" no es capicua");
		}
		
	}

}
