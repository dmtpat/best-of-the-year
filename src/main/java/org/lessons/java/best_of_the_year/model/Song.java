package org.lessons.java.best_of_the_year.model;

import java.io.Serializable;

public class Song implements Serializable{
    private int id;
    private String titolo;

    public Song() {

    }

    public Song(int id, String titolo) {
        this.id = id;
        this.titolo = titolo;
    }

    public int getId() {
        return id;
    }
    public String getTitolo() {
        return titolo;
    }
}
