/**
 * 
 */
package oo2;

/**
 * @author ikk
 *
 */
public class Loro  extends Ave{
	char region;
	String color;
	
	/**
	 * 
	 */
	public Loro(char sexo, int edad, char region, String color) {
		super(sexo, edad);
		this.region = region;
		this.color = color;
	}
	
	void deDondeEres(){
		if(region=='N' || region=='n'){
			System.out.println("Norte");
		}
		else{
			if(region=='S' || region=='s'){
				System.out.println("Sur");
			}
			else{
				if(region=='E' || region=='e'){
					System.out.println("Este");
				}
				else{
					System.out.println("Oeste");
				}
			}
		}
	}
	
	

}
