/**
 * 
 */
package progoo;

/**
 * @author ikk
 *
 */
public class Punto {
	int x, y;
	
	Punto(int x,int y){
		this.x = x;
		this.y = y;
	}
	int cuadrante(){
	
		if((x>0 && y>0))
			return 1;
		else
			if((x<0 && y>0))
			 return 2;
			else
				if((x<0 && y<0))
					return 3;
				else
					if((x>0 && y<0))
						return 4;
					else
						return 0;
	}

	void ver(){
		System.out.println("("+x+","+y+")");
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
