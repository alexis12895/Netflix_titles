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
public class Category {

    @NotNull
    private @Id
    @GeneratedValue Long id;

    @NotEmpty(message = "El nombre no puede ser nulo o vacio")
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Title> titles;

    public Category(String name, List<Title> titles) {
        this.id = id;
        this.name = name;
        this.titles = titles;
    }

    public Category(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(name, category.name) && Objects.equals(titles, category.titles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, titles);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", titles=" + titles +
                '}';
    }
}

