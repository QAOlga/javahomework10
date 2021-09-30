package ru.netology.domain;

public class FilmItem {

    private int id;
    private String filmName;
    private String filmGenre;

    public FilmItem(int id, String filmName, String filmGenre) {
        this.id = id;
        this.filmName = filmName;
        this.filmGenre = filmGenre;
    }
}
