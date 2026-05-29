package org.lessons.java.best_of_the_year.model;

import java.io.Serializable;

public class Movie implements Serializable{
    private int id;
    private String titolo;

    public Movie() {

    }
    
    public Movie(int id, String titolo) {
        this.id = id;
        this.titolo = titolo;
    }

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    
     @Override
    public String toString() {
        return this.titolo;
    }
}
