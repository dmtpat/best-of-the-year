package org.lessons.java.best_of_the_year.model;

import java.io.Serializable;

public class Song implements Serializable{
    private int id;
    private String titolo;
    private String image;

    public Song() {}

    public Song(int id, String titolo, String image) {
        this.id = id;
        this.titolo = titolo;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }
    public String getImage() {
        return image;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public String toString() {
        return this.titolo;
    }
}
