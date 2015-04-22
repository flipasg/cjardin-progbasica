/**
 *
 */
package ejemplo4;

/**
 * @author Iker Garcia Ramirez
 * @date 22/4/2015
 *
 */
public class Dia {
    private int d;
    private int m;

    /**
     * Constructor de la clase Dia
     *
     * @param d
     * @param m
     * @throws DiaException
     */
    public Dia(int d, int m) throws DiaException {
	if (m > 12 || m < 0)
	    throw new DiaException("Mes no valido");
	if ((m == 0 || m == 3 || m == 4 || m == 6 || m == 8 || m == 10)
		&& d > 30)
	    throw new DiaException("Dia no valido");
	else if (m == 1 && d > 28)
	    throw new DiaException("Dia no valido");
	else if (d > 31 || d < 0)
	    throw new DiaException("Dia no valido");

	this.d = d;
	this.m = m;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return d + "/" + m;
    }

}
