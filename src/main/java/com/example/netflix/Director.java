package com.example.netflix;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
public class Director {

    @NotNull
    private @Id
    @GeneratedValue Long id;

    @NotEmpty(message= "el nombre no puede ser nulo o vacio")
    private String name;

    @ManyToMany(mappedBy = "directors")
    private List<Title> titles;

    public Director(String name, List<Title> titles) {
        this.id = id;
        this.name = name;
        this.titles = titles;
    }

    public Director(){}

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
        Director director = (Director) o;
        return Objects.equals(id, director.id) && Objects.equals(name, director.name) && Objects.equals(titles, director.titles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, titles);
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", titles=" + titles +
                '}';
    }
}
