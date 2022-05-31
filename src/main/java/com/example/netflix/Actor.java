package com.example.netflix;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class Actor {

    @NotNull
    private @Id
    @GeneratedValue Long id;

    @NotNull(message = "el nombre no puede ser nulo o vacio")
    private String name;

    @ManyToMany(mappedBy = "actors")
    private List<Title> titles;

    public Actor(String name, List<Title> titles) {
        this.id = id;
        this.name = name;
        this.titles = titles;
    }

    public Actor(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(id, actor.id) && Objects.equals(name, actor.name) && Objects.equals(titles, actor.titles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, titles);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", titles=" + titles +
                '}';
    }
}
