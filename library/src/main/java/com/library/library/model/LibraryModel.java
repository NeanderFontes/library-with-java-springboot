package com.library.library.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "library")
public class LibraryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "isbn", nullable = false)
    private String ISBN;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "author", nullable = false)
    private String author;

    public LibraryModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryModel that = (LibraryModel) o;
        return id.equals(that.id) && ISBN.equals(that.ISBN) && name.equals(that.name) && author.equals(that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ISBN, name, author);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
