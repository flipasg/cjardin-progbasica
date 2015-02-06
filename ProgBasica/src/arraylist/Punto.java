/**
 * 
 */
package arraylist;

/**
 * @author ikk
 *
 */
public class Punto {
		private int x, y;
		
		public Punto(int x,int y){
			this.x = x;
			this.y = y;
		}
		
		
		
		/**
		 * @return the x
		 */
		public int getX() {
			return x;
		}



		/**
		 * @return the y
		 */
		public int getY() {
			return y;
		}



		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Punto [x=" + x + ", y=" + y + "]";
		}



		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			Punto other = (Punto) obj;
			if (x != other.x) {
				return false;
			}
			if (y != other.y) {
				return false;
			}
			return true;
		}
		
		
		
		
}
