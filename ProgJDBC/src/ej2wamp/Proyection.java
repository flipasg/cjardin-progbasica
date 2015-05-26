/**
 *
 */
package ej2wamp;

import java.util.Date;

/**
 * @author Iker Garcia Ramirez
 * @date 19/5/2015
 *
 */
public class Proyection {
    private String id;
    private Date date;
    private String place;
    private Film film;

    /**
     * Constructor de la clase Proyections
     */
    public Proyection() {
	this("", null, "", null);
    }

    /**
     * Constructor de la clase Proyections
     *
     * @param id
     * @param date
     * @param place
     * @param film
     */
    public Proyection(String id, Date date, String place, Film film) {
	this.id = id;
	this.date = date;
	this.place = place;
	this.film = film;
    }

    /**
     * @return the id
     */
    public String getId() {
	return id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
	return date;
    }

    /**
     * @return the place
     */
    public String getPlace() {
	return place;
    }

    /**
     * @return the film
     */
    public Film getFilm() {
	return film;
    }

}
