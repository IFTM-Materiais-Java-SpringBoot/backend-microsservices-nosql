package com.iftm.securityex.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Document(collection = "movie")
public class Movie implements Serializable {

    @Id
    private String id;
    private String title;
    private String description;
    @DBRef
    private List<Person> actors;
    @DBRef
    private List<Person> directors;

    public Movie() {
    }

    public Movie(String id, String title, String description, List<Person> actors, List<Person> directors) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.actors = actors;
        this.directors = directors;
    }

    public Movie(String title, String description, List<Person> actors, List<Person> directors) {
        this.title = title;
        this.description = description;
        this.actors = actors;
        this.directors = directors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Person> getActors() {
        return actors;
    }

    public void setActors(List<Person> actors) {
        this.actors = actors;
    }

    public List<Person> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && Objects.equals(description, movie.description) && Objects.equals(actors, movie.actors) && Objects.equals(directors, movie.directors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, actors, directors);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", actors=" + actors +
                ", directors=" + directors +
                '}';
    }
}
