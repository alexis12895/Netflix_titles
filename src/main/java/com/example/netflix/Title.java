package com.example.netflix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Title {

    @NotNull
    private @Id @GeneratedValue Long id;

    @JoinTable(name = "title_director",
            joinColumns = {@JoinColumn(name = "title_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "director_id", nullable = false)})
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Director> directors;

    @JoinTable(name = "title_actor",
            joinColumns = {@JoinColumn(name = "title_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "actor_id", nullable = false)})
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Actor> actors;

    @JoinTable(name = "title_category",
            joinColumns = {@JoinColumn(name = "title_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "category_id", nullable = false)})
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Category> categories;

    @NotEmpty(message = "el nombre del titulo debe no puede ser nulo o vacio")
    private String name;

    private String date_added;

    private String release_year;

    @NotEmpty(message = "el rating no puede ser nulo o vacio")
    private String rating;

    @NotEmpty(message = "la duracion no puede ser nula o vacia")
    private String duration;

    private String description;

    @Range(min = 1,max = 10)
    private float user_rating;

    @Min(1)
    private int num_rating;

    public Title(){}

    public Title(List<Director> directors, List<Actor> actors, List<Category> categories, String name, String date_added, String release_year, String rating, String duration, String description, String s, float user_rating, int num_rating) {
        this.directors = directors;
        this.actors = actors;
        this.categories = categories;
        this.name = name;
        this.date_added = date_added;
        this.release_year = release_year;
        this.rating = rating;
        this.duration = duration;
        this.description = description;
        this.user_rating = user_rating;
        this.num_rating = num_rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(float user_rating) {
        this.user_rating = user_rating;
    }

    public int getNum_rating() {
        return num_rating;
    }

    public void setNum_rating(int num_rating) {
        this.num_rating = num_rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return Float.compare(title.user_rating, user_rating) == 0 && num_rating == title.num_rating && Objects.equals(id, title.id) && Objects.equals(directors, title.directors) && Objects.equals(actors, title.actors) && Objects.equals(categories, title.categories) && Objects.equals(name, title.name) && Objects.equals(date_added, title.date_added) && Objects.equals(release_year, title.release_year) && Objects.equals(rating, title.rating) && Objects.equals(duration, title.duration) && Objects.equals(description, title.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, directors, actors, categories, name, date_added, release_year, rating, duration, description, user_rating, num_rating);
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", directors=" + directors +
                ", actors=" + actors +
                ", categories=" + categories +
                ", name='" + name + '\'' +
                ", date_added='" + date_added + '\'' +
                ", release_year='" + release_year + '\'' +
                ", rating='" + rating + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", user_rating=" + user_rating +
                ", num_rating=" + num_rating +
                '}';
    }
}
