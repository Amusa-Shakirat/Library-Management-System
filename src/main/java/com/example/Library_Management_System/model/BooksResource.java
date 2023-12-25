package com.example.Library_Management_System.model;

import org.springframework.hateoas.RepresentationModel;

public class BooksResource extends RepresentationModel<BooksResource> {

    private Books books;

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }
}
