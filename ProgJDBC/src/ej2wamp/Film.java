/**
 *
 */
package ej2wamp;

/**
 * @author Iker Garcia Ramirez
 * @date 19/5/2015
 *
 */
public class Film {
    private int id;
    private String name;
    private int year;
    private int taking;
    private boolean success;

    /**
     * Constructor de la clase Film
     */
    public Film() {
	this(0, "", 0, 0, false);
    }

    /**
     * @return the id
     */
    public int getId() {
	return id;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @return the year
     */
    public int getYear() {
	return year;
    }

    /**
     * @return the taking
     */
    public int getTaking() {
	return taking;
    }

    /**
     * @return the success
     */
    public boolean isSuccess() {
	return success;
    }

    /**
     * Constructor de la clase Film
     *
     * @param id
     * @param name
     * @param year
     * @param taking
     * @param success
     */
    public Film(int id, String name, int year, int taking, boolean success) {
	this.id = id;
	this.name = name;
	this.year = year;
	this.taking = taking;
	this.success = success;
    }

}
