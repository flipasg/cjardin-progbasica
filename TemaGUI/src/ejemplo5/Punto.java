/**
 * TemaGUI - ejemplo5 : Punto.java
 * @author Iker Garcia Ramirez
 * @date 31/03/2015
 */
package ejemplo5;

import java.awt.Color;
import java.awt.Point;

//Comienza la clase Punto
public class Punto {
    private Point p;
    private Color c;
    
    /**
     * Contructor de la clase Punto
     * @param p
     * @param c
     */
    public Punto(Point p, Color c) {
	this.p = p;
	this.c = c;
    }

    /**
     * Método obtener : getP
     * @return el p
     */
    public Point getP() {
        return p;
    }

    /**
     * Método obtener : getC
     * @return el c
     */
    public Color getC() {
        return c;
    }
    
    
}
