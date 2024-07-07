package com.library.library.DTO;

import java.util.Objects;

public class LibraryDTO {
    private String ISBN;
    private String name;
    private String author;

    public LibraryDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryDTO that = (LibraryDTO) o;
        return ISBN.equals(that.ISBN) && name.equals(that.name) && author.equals(that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, name, author);
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
