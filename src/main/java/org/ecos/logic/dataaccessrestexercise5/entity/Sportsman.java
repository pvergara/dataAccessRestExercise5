package org.ecos.logic.dataaccessrestexercise5.entity;

@SuppressWarnings("unused")
public class Sportman {
    private int id;
    private String name;
    private String sport;
    private boolean isActive;
    private String genre;

    public Sportman() {
    }

    public Sportman(int id, String name, String sport, boolean isActive, String genre) {
        this.id = id;
        this.name = name;
        this.sport = sport;
        this.isActive = isActive;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
