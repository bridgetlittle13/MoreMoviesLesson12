package com.example.moremovieslesson12;

import java.io.Serializable;

public class movie implements Serializable {
    private int id;
    private String title;
    private String genre;
    private int year;
    private String rating;

    public movie(int id, String title, String genre, int year, String rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public static void add(movie obj) {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setMovieTitle(String title) {
        this.title = title;
    }

    public String getGenre() { return genre; }

    public void setMovieGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setMovieYear(int year) {
        this.year = year;
    }

    public String getRating() { return rating; }

    public void setMovieRating(String rating) {
        this.rating = rating;
    }

//    @Override
//    public String toString()
//    {
//        return "Movie{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", genre='" + genre + '\'' +
//                ", year=" + year +
//                ", rating='" + rating + '\'' +
//                '}';
//    }

}
