package model;

import java.util.Date;

public class Book {
    private int id;
    private String name;
    private String genre;
    private String author;
    private Integer quantityPages;

    public Book() {
    }

    public Book(int id, String name, String genre, String author, Integer quantityPages) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.quantityPages = quantityPages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantityPages() {
        return quantityPages;
    }

    public void setQuantityPages(Integer quantityPages) {
        this.quantityPages = quantityPages;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Nome: " + name + ", Gênero: " + genre + ", Autor: " + author + ", Páginas: " + quantityPages;
    }
}