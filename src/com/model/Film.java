package com.model;

import java.util.Date;

/**
 * Created by asouqi on 3/13/18.
 */
public class Film {

    private long id;
    private String title;
    private String description;
    private int    release_year;

    public Film(long id, String title, String description, int release_year) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.release_year = release_year;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getRelease_year() {
        return release_year;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", release_year=" + release_year +
                '}';
    }
}
