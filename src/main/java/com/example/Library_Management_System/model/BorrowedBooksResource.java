package com.example.Library_Management_System.model;

import org.springframework.hateoas.RepresentationModel;

public class BorrowedBooksResource extends RepresentationModel<BorrowedBooksResource> {


    private BorrowedBooks borrowedBooks;

    public BorrowedBooks getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(BorrowedBooks borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
